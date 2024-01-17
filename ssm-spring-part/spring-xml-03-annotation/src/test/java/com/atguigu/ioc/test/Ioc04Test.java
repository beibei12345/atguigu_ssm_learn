package com.atguigu.ioc.test;

import com.atguigu.ioc04.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ioc04Test {
    @Test
    public void test01(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-04.xml");

        JavaBean bean = applicationContext.getBean(JavaBean.class);
        System.out.println(bean);

        applicationContext.close();
    }
}
