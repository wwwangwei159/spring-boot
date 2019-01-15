package com.train.springmvc.service;


import com.train.springmvc.dao.entity.user.User;

import java.util.List;

public interface UserService {

    User getUserById(Integer userId);

    List<User> getAllUser();

    void saveUsers(List<User> users);

    void saveUser(User user);
}
