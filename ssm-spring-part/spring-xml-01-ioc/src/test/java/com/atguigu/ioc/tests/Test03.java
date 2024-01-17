package com.atguigu.ioc.tests;

import com.atguigu.ioc.ioc03.A;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-03.xml");
        context.refresh();

//        HappyComponent happyComponent = context.getBean("happyComponent", HappyComponent.class);
//        System.out.println(happyComponent);

        A bean = context.getBean(A.class);
        bean.doWork();

        context.close();
    }
}
