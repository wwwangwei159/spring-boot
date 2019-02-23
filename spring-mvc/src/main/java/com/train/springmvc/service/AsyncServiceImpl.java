package com.train.springmvc.service;

import com.train.springmvc.dao.entity.user.User;
import com.train.springmvc.dao.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {


    @Autowired
    private UserRepository userRepository;

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {

        log.info("start executeAsync");
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        log.info("end executeAsync");

    }

    @Override
    @Async("asyncServiceExecutor")
    public void saveUser(User user) {

        try{
            Thread.sleep(2000);
            userRepository.save(user);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
