package com.atguigu.ioc03;

import org.springframework.stereotype.Service;

@Service(value = "userService1")
public class NewUserServiceImpl implements UserService{
    @Override
    public String show() {
        return "NewUserServiceImpl show();";
    }
}
