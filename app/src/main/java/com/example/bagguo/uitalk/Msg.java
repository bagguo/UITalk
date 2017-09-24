package com.example.bagguo.uitalk;

/**
 * Created by bagguo on 2017/9/24.
 */

public class Msg {
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SEND=1;
    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
