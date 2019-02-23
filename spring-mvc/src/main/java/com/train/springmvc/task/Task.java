package com.train.springmvc.task;

import com.train.springmvc.cache.Cache;
import com.train.springmvc.dao.entity.user.User;
import com.train.springmvc.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@Component
public class Task {

    @Autowired
    private Cache cache;

    @Async
    public Future<User> testAsync1(Integer userId) {

        long start = System.currentTimeMillis();
        User user = cache.getUserByUserId(userId);
        Future<User> future = new AsyncResult<User>(user);
        long end = System.currentTimeMillis();
        System.out.println("-------task1==" + (end - start));
        return future;
    }

    @Async
    public Future<List<User>> testAsync2() {
        long start = System.currentTimeMillis();
        List<User> userList = cache.getAllUsers();
        Future<List<User>> future = new AsyncResult<List<User>>(userList);
        long end = System.currentTimeMillis();
        System.out.println("-------task2==" + (end - start));
        return future;
    }

}
