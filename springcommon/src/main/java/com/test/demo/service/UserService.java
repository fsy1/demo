package com.test.demo.service;

import com.test.demo.domin.User;
import com.test.demo.hystrixfailbackfactory.UserServiceHystrixFailBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PROVIDER8001",fallbackFactory = UserServiceHystrixFailBackFactory.class)
@RequestMapping("/provider")
public interface UserService {

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id);
}
