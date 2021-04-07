package com.ohyoung.domain.repository;

import com.ohyoung.domain.entity.User;

public interface UserRepository {

    User findUserById(String id);

    User updateUserName(String id, String name);

    void deleteUserById(String id);
}
