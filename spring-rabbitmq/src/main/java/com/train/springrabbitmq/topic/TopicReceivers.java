package com.train.springrabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceivers {

    @RabbitHandler
    public void process(String message){

        System.out.println("Topic Receivers  many  : " + message);

    }

}
