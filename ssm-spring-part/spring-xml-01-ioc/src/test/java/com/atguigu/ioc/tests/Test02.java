package com.atguigu.ioc.tests;

import com.atguigu.ioc.ioc02.SimpleMovieLister;
import com.atguigu.ioc.ioc02.UserDao;
import com.atguigu.ioc.ioc02.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-02.xml");
        context.refresh();

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);

        System.out.println("-----------------");
        UserService userService1 = (UserService) context.getBean("userService1");
        System.out.println(userService1);
        UserService userService2 = context.getBean("userService2", UserService.class);
        System.out.println(userService2);
        UserService userService3 = context.getBean("userService3", UserService.class);
        System.out.println(userService3);

        System.out.println("-----------------");
        SimpleMovieLister simpleMovieLister = context.getBean(SimpleMovieLister.class);
        System.out.println(simpleMovieLister);

        context.close();
    }
}
