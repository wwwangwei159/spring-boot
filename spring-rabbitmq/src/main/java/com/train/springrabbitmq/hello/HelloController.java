package com.train.springrabbitmq.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloSender helloSender;

    @GetMapping(value = "/hello")
    public String testHello(@RequestParam("sender") String sender){

        String message  = helloSender.send("你好:"+sender);

        return "发送成功"+message;

    }


}
