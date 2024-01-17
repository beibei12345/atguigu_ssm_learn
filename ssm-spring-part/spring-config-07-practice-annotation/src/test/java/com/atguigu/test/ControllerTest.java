package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ControllerTest {
    @Test
    public void testRun(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController studentController = context.getBean("studentController", StudentController.class);
        studentController.findAll();
        context.close();
    }
}
