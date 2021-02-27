/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.netty.file;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author buhao
 * @version FileServerHandler.java, v 0.1 2021-01-03 16:16 buhao
 */
public class FileServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        final ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + ":服务端读到 -> " + byteBuf.toString(StandardCharsets.UTF_8));

        System.out.println(new Date() + "：服务端写出数据");
        final ByteBuf out = getByteBuf(ctx);
        ctx.channel().writeAndFlush(out);
    }


    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        final ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes("hello client".getBytes(StandardCharsets.UTF_8));
        return buffer;
    }

}