package com.example.bagguo.uitalk;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bagguo on 2017/9/24.
 */

public class MsgAdapter extends Adapter<MsgAdapter.ViewHolder> {
    List<Msg> mMsgList;

    public MsgAdapter(List<Msg> msgList) {
        mMsgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            holder.msgRight.setVisibility(View.GONE);
            holder.msgLeft.setVisibility(View.VISIBLE);
            holder.msgLeft.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SEND) {
            holder.msgLeft.setVisibility(View.GONE);
            holder.msgRight.setVisibility(View.VISIBLE);
            holder.msgRight.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    //继承recyclerview的viewholder
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView msgLeft, msgRight;

        public ViewHolder(View itemView) {
            super(itemView);
            msgLeft = itemView.findViewById(R.id.msg_left);
            msgRight = itemView.findViewById(R.id.msg_right);
        }
    }
}
