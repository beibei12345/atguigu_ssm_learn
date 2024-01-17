package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigurationA {
    @Bean
    public String testStrBean(){
        return "testStrBean";
    }
}
