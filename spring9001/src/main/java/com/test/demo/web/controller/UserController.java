package com.test.demo.web.controller;

import com.test.demo.domin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User forObject = restTemplate.getForObject("http://PROVIDER8001/provider/user/" + id, User.class);
        System.out.println(forObject.toString());
        return forObject;
    }
}
