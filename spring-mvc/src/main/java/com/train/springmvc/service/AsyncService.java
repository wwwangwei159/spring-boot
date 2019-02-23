package com.train.springmvc.service;

import com.train.springmvc.dao.entity.user.User;

public interface AsyncService {

    void executeAsync();

    void saveUser(User user);

}
