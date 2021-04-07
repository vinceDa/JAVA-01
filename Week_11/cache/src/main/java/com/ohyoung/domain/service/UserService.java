package com.ohyoung.domain.service;

import com.ohyoung.domain.entity.User;

public interface UserService {

    User findUserById(String userId);

    User updateUserName(String userId,String name);

    void deleteUserById(String userId);
}
