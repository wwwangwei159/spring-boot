package com.train.springmvc.cache;

import com.train.springmvc.dao.entity.user.User;
import com.train.springmvc.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class CacheImpl implements Cache {


    @Autowired
    UserRepository userRepository;

    @Override
    @Cacheable(value={"'UserCacheImpl.getUser'"},key = "#userId")
    public User getUserByUserId(Integer userId) {
        return userRepository.getUserByUserId(userId);
    }
}
