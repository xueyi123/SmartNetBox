package com.iih5.netbox.codec.ws;
import com.iih5.netbox.core.GlobalConstant;
import com.iih5.netbox.core.ProtocolConstant;
import com.iih5.netbox.message.ByteMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class WsBinaryForDefaultByteDecoder extends WsBinaryDecoder{
    private Logger logger = LoggerFactory.getLogger(WsBinaryForDefaultByteDecoder.class);
    @Override
    public void decode(Channel ctx, ByteBuf buffer, List<Object> out) {
        byte headFlag=buffer.readByte(); //headFlag
        if (headFlag!= ProtocolConstant.PACK_HEAD_FLAG){
            if (GlobalConstant.debug){
                logger.error("检测到包头标识错误，正确包头应为："+ProtocolConstant.PACK_HEAD_FLAG);
            }else {
                ctx.disconnect().channel().close();
            }
        }
        int packLen=buffer.readInt(); //packLen
        short msgId = buffer.readShort(); //cmdID
        byte encr=buffer.readByte(); //encr
        ByteBuf msgBuf = Unpooled.buffer(buffer.readableBytes());//content
        buffer.readBytes(msgBuf);
        ByteMessage byteMessage = new ByteMessage(msgId);
        byteMessage.setEncrypt(encr);
        byteMessage.setContent(msgBuf);
        out.add(byteMessage);
    }
    public ByteMessage unPack(byte[] arr){
        ByteBuf buffer = Unpooled.copiedBuffer(arr);
        byte headFlag=buffer.readByte(); //headFlag
        int packLen=buffer.readInt(); //packLen
        short msgId = buffer.readShort(); //cmdID
        byte encr=buffer.readByte(); //encr
        ByteBuf msgBuf = Unpooled.buffer(buffer.readableBytes());//content
        buffer.readBytes(msgBuf);
        ByteMessage byteMessage = new ByteMessage(msgId);
        byteMessage.setEncrypt(encr);
        byteMessage.setContent(msgBuf);
       return byteMessage;
    }
}
