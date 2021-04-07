package com.ohyoung.user;

import com.ohyoung.user.domain.entity.User;
import com.ohyoung.user.domain.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User getById(int id) {
        return new User(id, "xianyanyang");
    }
}
