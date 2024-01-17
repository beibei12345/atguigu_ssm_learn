package com.atguigu.ioc.test;

import com.atguigu.ioc01.CommonComponent;
import com.atguigu.ioc01.XxxController;
import com.atguigu.ioc01.XxxDao;
import com.atguigu.ioc01.XxxService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ioc01Test {
    @Test
    public void test01(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");

        CommonComponent bean = applicationContext.getBean(CommonComponent.class);
        System.out.println(bean);
        CommonComponent commonComponent = (CommonComponent) applicationContext.getBean("commonComponent");
        System.out.println(commonComponent);

        applicationContext.close();
    }

    @Test
    public void test02(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");

        XxxController bean = applicationContext.getBean(XxxController.class);
        System.out.println(bean);
        XxxController ergouzi = (XxxController) applicationContext.getBean("ergouzi");
        System.out.println(ergouzi);
        XxxController ergouzi1 = applicationContext.getBean("ergouzi", XxxController.class);
        System.out.println(ergouzi1);

        applicationContext.close();
    }

    @Test
    public void test03(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");

        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println(bean);

        applicationContext.close();
    }

    @Test
    public void test04(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");

        XxxService bean = applicationContext.getBean(XxxService.class);
        System.out.println(bean);
        XxxService vvService = (XxxService) applicationContext.getBean("vvService");
        System.out.println(vvService);

        applicationContext.close();
    }

    @Test
    public void test05(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01-ex1.xml");

        XxxService bean = applicationContext.getBean(XxxService.class);
        System.out.println(bean);
        XxxService vvService = (XxxService) applicationContext.getBean("vvService");
        System.out.println(vvService);
//        XxxController bean2 = applicationContext.getBean(XxxController.class);
//        System.out.println(bean2);

        applicationContext.close();
    }

    @Test
    public void test06(){
        //1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01-ex1.xml");

        XxxService bean = applicationContext.getBean(XxxService.class);
        System.out.println(bean);
        XxxService vvService = (XxxService) applicationContext.getBean("vvService");
        System.out.println(vvService);
//        XxxController bean2 = applicationContext.getBean(XxxController.class);
//        System.out.println(bean2);

        applicationContext.close();
    }
}
