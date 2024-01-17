package com.atguigu.ioc.tests;

import com.atguigu.ioc.ioc05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {
    @Test
    public void test02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-05.xml");
        context.refresh();

        JavaBean javabean = context.getBean("javaBean", JavaBean.class);
        JavaBean javabean2 = context.getBean("javaBean", JavaBean.class);
        System.out.println(javabean == javabean2);


        context.close();
    }
}
