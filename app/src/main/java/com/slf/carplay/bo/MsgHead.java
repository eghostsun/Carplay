package com.slf.carplay.bo;

public class MsgHead {
    private short event;
    private int bodyLen;

    public short getEvent() {
        return event;
    }

    public void setEvent(short event) {
        this.event = event;
    }

    public int getBodyLen() {
        return bodyLen;
    }

    public void setBodyLen(int bodyLen) {
        this.bodyLen = bodyLen;
    }
}
