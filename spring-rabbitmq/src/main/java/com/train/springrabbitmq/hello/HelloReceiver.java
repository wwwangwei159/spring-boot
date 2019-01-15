package com.train.springrabbitmq.hello;

import com.train.springmvc.dao.entity.user.User;
import com.train.springmvc.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @Autowired(required = false)
    private UserService userService;

    @RabbitHandler
    public void process(@RequestParam("userName") String userName){

        User user  = new User();
        user.setUserName(userName);
        user.setAge(10);
        user.setEmail(userName+"@qq.com");
        userService.saveUser(user);

        System.out.println("HelloReceiver 单对单接收参数  : " + userName);

    }

}
