package com.example.bagguo.uitalk;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Msg> mMsgList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button btnSend;
    private EditText editText;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSend = (Button) findViewById(R.id.btn_send);
        editText = (EditText) findViewById(R.id.edit_text);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        btnSend.setOnClickListener(mListener);
        editText.setOnClickListener(mListener);
        recyclerView.setOnClickListener(mListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        initContent();
        adapter = new MsgAdapter(mMsgList);
        recyclerView.setAdapter(adapter);

    }

    View.OnClickListener mListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_send:
                    String content = editText.getText().toString();
                    if (!"".equals(content)) {//!equales("")与!=null的区别
                        Msg msg = new Msg(content, Msg.TYPE_SEND);
                        mMsgList.add(msg);
                        adapter.notifyItemInserted(mMsgList.size() - 1);
                        recyclerView.scrollToPosition(mMsgList.size() - 1);
                        editText.setText("");
                    }
                    break;
                case R.id.edit_text:
                    recyclerView.scrollToPosition(mMsgList.size() - 1);
                    break;
                case R.id.recycler_view:
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    break;
            }
        }
    };

    private void initContent() {
        Msg msg1 = new Msg("Hi", Msg.TYPE_RECEIVED);
        mMsgList.add(msg1);
        Msg msg2 = new Msg("你好", Msg.TYPE_SEND);
        mMsgList.add(msg2);
        Msg msg3 = new Msg("我是杰克", Msg.TYPE_RECEIVED);
        mMsgList.add(msg3);
    }
}
