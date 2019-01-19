package com.train.springmvc.controller;

import com.train.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("/userIndex")
    @ResponseBody
    public ModelAndView index(){

        ModelAndView vm = new ModelAndView();

        vm.setViewName("index");

        vm.addObject("content","hello world");

        vm.addObject("dateSqlVar","test123");

        vm.addObject("name","sparking...when study...");

        vm.addObject("user",userService.getAllUser());

        return vm;
    }

}
