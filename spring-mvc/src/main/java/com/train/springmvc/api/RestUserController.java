package com.train.springmvc.api;

import com.train.springmvc.dao.entity.user.User;
import com.train.springmvc.service.AsyncService;
import com.train.springmvc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class RestUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AsyncService asyncService;

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String  queryUser(@RequestParam("userId") Integer userId){

        System.out.println("queryUser:::"+userId);

        asyncService.executeAsync();
        asyncService.executeAsync();
        asyncService.executeAsync();
        asyncService.executeAsync();
        asyncService.executeAsync();
        asyncService.executeAsync();
        asyncService.executeAsync();
        asyncService.executeAsync();
        asyncService.executeAsync();
        asyncService.executeAsync();

        String user = JsonHelper.convertJson(userService.getUserById(userId));

        System.out.println("already return:::"+userId);

        return user;
    }

    @ApiOperation(value = "保存用户" ,  notes="保存用户")
    @ApiImplicitParam(name = "userCount", value = "用户标识", required = true, paramType = "save", dataType = "Integer")
    @RequestMapping(value="/postUser",method=RequestMethod.POST)
    public void  postUser(@RequestBody() Integer userCount){

        System.out.println("queryUser:::"+userCount);

        for (int i=0;i<userCount;i++){
            User user = new User();
            user.setAge(i);
            user.setEmail(i+"dsfdsf@qq.com");
            user.setUserName("姓名"+i);
            System.out.println("save begin "+i);
            asyncService.saveUser(user);
            System.out.println("save end "+i);
        }
        System.out.println("already return:::"+userCount);
    }




}
