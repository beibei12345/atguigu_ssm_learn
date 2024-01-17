package com.atguigu.service;

import org.springframework.stereotype.Service;

@Service
public class ASimpleService {
    public String simpleService(String arg1, String arg2, String arg3){
        System.out.println("执行业务中");
        return arg1 + arg2 + arg3;
    }
}
