package com.test.demo.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.demo.domin.User;
import com.test.demo.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class UserController implements UserService{

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @Override
    public User getUser(@PathVariable("id") Integer id){
        return new User("fsy8001",id);
    }

    public User getUserFailBack(){
        return new User("错误",1);
    }
}
