package com.atguigu.controller;

import com.atguigu.properties.DataSourceConfigurationProperties;
import com.atguigu.properties.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private DataSourceConfigurationProperties dataSourceConfigurationProperties;

    @RequestMapping("/hello")
    public String sayHello(){
        return dataSourceProperties.toString();
    }

    @RequestMapping("/hello2")
    public DataSourceConfigurationProperties sayHello2(){
        System.out.println(dataSourceConfigurationProperties);
        return dataSourceConfigurationProperties;
    }
}
