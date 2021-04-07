package com.ohyoung;

import com.ohyoung.rpc.client.ProxyFactory;
import com.ohyoung.rpc.exception.RpcException;
import com.ohyoung.user.domain.entity.User;
import com.ohyoung.user.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ohYoung
 * @date 2021/4/8 0:29
 */
@Slf4j
public class Client {

    public static void main(String[] args) {
        try {
            UserService userService = ProxyFactory.getProxy(UserService.class, new RandomLoadBalancer());
            User user = userService.getById(123);
            if (user != null) {
                log.info("username:{}", user.getName());
            }
        } catch (RpcException e) {
            log.info("Client error", e.getMessage());
        }
    }

}
