package com.test.demo.hystrixfailbackfactory;

import com.test.demo.domin.User;
import com.test.demo.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrixFailBackFactory implements FallbackFactory<UserService>{
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public User getUser(Integer id) {
                return new User("操作失败",111);
            }
        };
    }
}
