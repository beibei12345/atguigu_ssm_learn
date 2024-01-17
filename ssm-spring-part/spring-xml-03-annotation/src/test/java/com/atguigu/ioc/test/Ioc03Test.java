package com.atguigu.ioc.test;

import com.atguigu.ioc03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ioc03Test {
    @Test
    public void test01(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-03.xml");

        UserController bean = applicationContext.getBean(UserController.class);
        bean.show();
        //bean.show2();

        applicationContext.close();
    }
}
