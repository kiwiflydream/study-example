/*
 *
 *  * *
 *  *  * blog.coder4j.cn
 *  *  * Copyright (C) 2016-2021 All Rights Reserved.
 *  *
 *
 */
package cn.coder4j.study.example.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author buhao
 * @version NettyServer.java, v 0.1 2021-01-03 15:15 buhao
 */
public class NettyServer {
    public static void main(String[] args) {
        // 引导类，引导服务启动
        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 作用：监听端口，接收新连接的线程组
        // 老板：负责接活
        final NioEventLoopGroup boss = new NioEventLoopGroup();
        // 作用：数据读写的线程组
        // 打工人：负责干活
        final NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap
                // 指定两大线程组 (线程模型)
                .group(boss, worker)
                // 指定 IO 模型，这里使用的是 NIO 。
                .channel(NioServerSocketChannel.class)
                // 定义每条连接的数据读写与业务逻辑
                // NioSocketChannel、 NioServerSocketChannel 类似于 Socket 、ServerSocket
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast(new StringDecoder());
                        nioSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
                                System.out.println(s);
                            }
                        });
                    }
                })
                .bind(8000);
    }
}