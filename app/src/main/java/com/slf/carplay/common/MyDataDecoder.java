package com.slf.carplay.common;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class MyDataDecoder extends CumulativeProtocolDecoder {
    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {

        if(in.remaining() < 4)
        {
            return false;
        }
        if(in.remaining() > 1)
        {
            in.mark();
            int len = in.getInt();
            if(len > in.remaining() - 2)
            {
                in.reset();
                return false;
            }else{
                in.reset();
                int totleLen = 6 + len; //总长度 = 包头 + 包体
                byte packet[] = new byte[totleLen];
                in.get(packet,0,totleLen);
                IoBuffer buffer = IoBuffer.allocate(totleLen);
                buffer.put(packet);
                buffer.flip();
                out.write(buffer);
                if(in.remaining() > 0)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
