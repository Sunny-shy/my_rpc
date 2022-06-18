package com.lagou.service.impl;

import com.lagou.service.UserService;
import com.lagou.service.handler.UserServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author ADMIN
 * @date 2022/6/17 9:31
 */
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(String msg) {
        System.out.println("调用成功--参数" + msg);
        return "调用成功--参数" + msg;
    }


        public static void startServer(String hostName, int port) {
            try {
                NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(eventLoopGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline p = ch.pipeline();
                                p.addLast(new StringDecoder());
                                p.addLast(new StringEncoder());
                                p.addLast(new UserServerHandler());
                            }
                        });
                bootstrap.bind(hostName, port).sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
