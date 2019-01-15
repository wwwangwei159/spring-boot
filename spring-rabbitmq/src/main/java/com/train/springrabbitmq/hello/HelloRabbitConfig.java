package com.train.springrabbitmq.hello;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloRabbitConfig {

    final static String message = "hello";

    @Bean
    public Queue helloMessage(){
        return new Queue(message);
    }




}
