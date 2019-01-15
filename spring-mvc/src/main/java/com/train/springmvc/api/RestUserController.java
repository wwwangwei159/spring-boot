package com.train.springmvc.api;

import com.train.springmvc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class RestUserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String  queryUser(@RequestParam("userId") Integer userId){

        System.out.println("queryUser:::"+userId);

        return JsonHelper.convertJson(userService.getUserById(userId));
    }




}
