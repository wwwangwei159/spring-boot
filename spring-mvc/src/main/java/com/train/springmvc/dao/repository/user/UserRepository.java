package com.train.springmvc.dao.repository.user;

import com.train.springmvc.dao.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("from User where userId = :userId ")
    User getUserId(@Param("userId") Integer userId);

    User getUserByUserId(@Param("userId") Integer userId);

    @Query("from User")
    List<User> getAllUser();

}
