package com.train.springmvc.service;


import com.train.springmvc.cache.Cache;
import com.train.springmvc.dao.entity.user.User;
import com.train.springmvc.dao.repository.user.UserRepository;
import com.train.springmvc.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Task task;

    @Override
    public User getUserById(Integer userId) {

        User user = null;
        Future<User> task1 = task.testAsync1(userId);
        Future<List<User>> task2 = task.testAsync2();
        try {
            user = task1.get();
            task2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return user;

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
