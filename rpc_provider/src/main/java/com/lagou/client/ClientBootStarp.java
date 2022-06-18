package com.lagou.client;

import com.lagou.service.UserService;

/**
 * @author ADMIN
 * @date 2022/6/17 15:07
 */
public class ClientBootStarp {
    public static final String providerName = "UserService#sayHello#";
    public static void main(String[] args) throws InterruptedException {
        RpcConsumer rpcConsumer = new RpcConsumer();
        UserService proxy = (UserService) rpcConsumer.createProxy(UserService.class, providerName);
        while (true) {
            Thread.sleep(2000);
            System.out.println();
            proxy.sayHello("are you ok ?");
        }

    }
}
