package com.atguigu.test;

import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ControllerTest {
    @Test
    public void testRun(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        StudentController studentController = context.getBean("studentController", StudentController.class);
        studentController.findAll();
    }
}
