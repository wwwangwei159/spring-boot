package com.train.springmvc.cache;

import com.train.springmvc.dao.entity.user.User;

import java.util.List;

public interface Cache {

    User getUserByUserId(Integer userId);

    List<User> getAllUsers();
}
