package com.train.springrabbitmq.topic;


import com.train.springrabbitmq.util.JsonHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "message interface")
@RestController
@RequestMapping("/topic")
public class TopciController {

    @Autowired
    TopicSender topicSender;


    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @GetMapping(value = "/send")
    public String send(){

        System.out.println("TopciController send method");

        topicSender.sendTopicMessage();


        return JsonHelper.convertJson(" send success");
    }

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @GetMapping(value = "/send1")
    public String send1(){

        System.out.println("TopciController send1 method");

        topicSender.sendTopicMessage1();

        return JsonHelper.convertJson("send1 success");
    }

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @GetMapping(value = "/sends")
    public String sends(){

        System.out.println("TopciController sends method");

        topicSender.sendTopicMessages();

        return JsonHelper.convertJson(" sends success");
    }

}
