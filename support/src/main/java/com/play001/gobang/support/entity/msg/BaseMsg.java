package com.play001.gobang.support.entity.msg;

import java.io.Serializable;

/**
 * 消息基类,状态,创建时间,消息类型
 * 必须实现Serializable接口,不然无法传递消息
 */
public class BaseMsg implements Serializable{

    //errMsg 不为null或者空则表示有错
    private String errMsg;
    private short type;
    private long time;
    public BaseMsg() {
    }

    public BaseMsg(short type, long time) {
        this.type = type;
        this.time = time;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
