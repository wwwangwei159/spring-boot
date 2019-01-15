package com.train.springrabbitmq.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

    // 1 vs 1 发送

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public String  send(String context) {
        if(context==null){
            context = "hello " + "你好我是单对单测试";
        }
        System.out.println("HelloSender 单对单发送参数 : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
        return "发送成功:"+context;
    }

}
