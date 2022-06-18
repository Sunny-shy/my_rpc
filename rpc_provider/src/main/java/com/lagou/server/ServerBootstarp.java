package com.lagou.server;

import com.lagou.service.impl.UserServiceImpl;

/**
 * @author ADMIN
 * @date 2022/6/17 9:47
 */
public class ServerBootstarp {
    public static void main(String[] args) {
        UserServiceImpl.startServer("127.0.0.1", 8999);
    }
}
