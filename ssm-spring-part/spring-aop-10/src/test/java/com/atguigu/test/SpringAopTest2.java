package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class SpringAopTest2 {
    @Autowired
    private Calculator calculator;

    @Test
    public void test01(){
        int add = calculator.add(1, 1);
        System.out.println(add);
    }

    @Test
    public void test03(){
        int add = calculator.div(1, 0);
        System.out.println(add);
    }
}
