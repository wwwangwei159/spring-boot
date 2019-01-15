package com.train.springrabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;




    public void sendTopicMessage(){

        String content = "topic.message";

        rabbitTemplate.convertAndSend("topicExchange","topic.message",content);

    }

    public void sendTopicMessage1(){

        String content = "topic.1";

        rabbitTemplate.convertAndSend("topicExchange","topic.1",content);

    }

    public void sendTopicMessages(){

        String content = "topic.messages";

        rabbitTemplate.convertAndSend("topicExchange","topic.messages",content);

    }





}
