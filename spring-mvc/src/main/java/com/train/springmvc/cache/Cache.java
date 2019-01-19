package com.train.springmvc.cache;

import com.train.springmvc.dao.entity.user.User;

public interface Cache {

    User getUserByUserId(Integer userId);
}
