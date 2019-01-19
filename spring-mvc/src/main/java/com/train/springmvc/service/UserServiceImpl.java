package com.train.springmvc.service;

import com.train.springmvc.cache.Cache;
import com.train.springmvc.dao.entity.user.User;
import com.train.springmvc.dao.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    Cache cache;

    @Override
    public User getUserById(Integer userId) {

        return cache.getUserByUserId(userId);

    }

    @Override
    public List<User> getAllUser() {

        return userRepository.getAllUser();

    }

    @Override
    public void saveUsers(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

}
