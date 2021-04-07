package com.ohyoung.user.web;

import com.ohyoung.rpc.client.proxy.ProxyFactory;
import com.ohyoung.user.domain.entity.User;
import com.ohyoung.user.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUserController {

    @Autowired
    private ProxyFactory proxyFactory;

    @GetMapping(value = "/users/{userId}", name = "getUserById")
    public Object getUser(@PathVariable() int userId) {
        UserService userService = proxyFactory.getProxy(UserService.class);
        User user = userService.getById(userId);
        if (user == null) {
            return null;
        }
        return user.getName();
    }
}
