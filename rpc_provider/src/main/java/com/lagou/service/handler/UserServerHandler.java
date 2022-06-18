package com.lagou.service.handler;

import com.lagou.service.impl.UserServiceImpl;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @author ADMIN
 * @date 2022/6/17 9:34
 */
public class UserServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //判断是否符合约定,符合则调用本地方法,返回数据
        //msg: UserService#sayHello#are you ok?
        if (msg.toString().startsWith("UserService")) {
            UserServiceImpl userService = new UserServiceImpl();

            String s = userService.sayHello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1, msg.toString().length()));
            ctx.writeAndFlush(s);
        }
    }
}
