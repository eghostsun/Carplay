package com.slf.carplay.common;

import com.slf.carplay.bo.MsgHead;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

public class HandlerEvent {

    private static HandlerEvent handleEvent;

    public static HandlerEvent getInstance()
    {
        if(handleEvent == null)
        {
            handleEvent = new HandlerEvent();
        }
        return handleEvent;
    }

    public void handle(IoSession session, IoBuffer buffer)
    {
        MsgHead msgHead = new MsgHead();
        msgHead.setBodyLen(buffer.getInt());
        msgHead.setEvent(buffer.getShort());

        switch (msgHead.getEvent())
        {
            //业务处理
        }
    }
}
