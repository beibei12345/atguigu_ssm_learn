package com.atguigu.ioc.tests;

import com.atguigu.ioc.ioc04.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-04.xml");
        context.refresh();

        JavaBean javabean = context.getBean("javabean", JavaBean.class);
        JavaBean javabean2 = context.getBean("javabean", JavaBean.class);


        context.close();
    }

    @Test
    public void test02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-04.xml");
        context.refresh();

        JavaBean javabean = context.getBean("javabean02", JavaBean.class);
        JavaBean javabean2 = context.getBean("javabean02", JavaBean.class);


        context.close();
    }
}
