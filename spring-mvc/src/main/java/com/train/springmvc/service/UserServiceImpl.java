package com.train.springmvc.service;


import com.train.springmvc.cache.Cache;
import com.train.springmvc.dao.entity.user.User;
import com.train.springmvc.dao.repository.user.UserRepository;
import com.train.springmvc.task.TaskTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    Cache cache;

    @Autowired
    TaskTest task;

    @Override
    public User getUserById(Integer userId) {

        Future<Map> task1 = task.testAsync1();
        Future<String> task2 = task.testAsync2(1);
        while(true){
            if(task1.isDone()&&task2.isDone()){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Map a = task1.get();
            System.out.println("map ================= "+a.get("a"));
            System.out.println("map ================= "+a.get("b"));
            System.out.println("map ================= "+a.get("c"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

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
