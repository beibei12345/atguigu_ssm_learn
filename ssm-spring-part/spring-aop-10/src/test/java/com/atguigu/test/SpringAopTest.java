package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.service.ASimpleService;
import com.atguigu.service.Calculator;
import com.atguigu.service.impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {
    @Autowired
    private Calculator calculator;

    @Autowired
    private ASimpleService aSimpleService;

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

    @Test
    public void test04(){
        aSimpleService.simpleService("1", "2", "34");
    }
}
