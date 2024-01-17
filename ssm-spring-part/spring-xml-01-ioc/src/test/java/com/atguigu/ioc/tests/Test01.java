package com.atguigu.ioc.tests;

import com.atguigu.ioc.ioc01.ClientService;
import com.atguigu.ioc.ioc01.ClientServiceImpl;
import com.atguigu.ioc.ioc01.ClientServiceImpl2;
import com.atguigu.ioc.ioc01.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("spring-01.xml");
        context.refresh();


        System.out.println("--------------");
        HappyComponent happyComponent = (HappyComponent) context.getBean("happyComponent");
        happyComponent.doWork();

        ClientService clientService = context.getBean(ClientService.class);
        clientService.clientDoWork();


        System.out.println("--------------");
        String string = context.getBean("clientServiceString", String.class);
        System.out.println(string);
        String string2 = context.getBean("clientServiceString2", String.class);
        System.out.println(string2);
        String string3 = context.getBean("clientServiceString2", String.class);
        System.out.println(string3);
        System.out.println("--------------");

        ClientServiceImpl service = context.getBean("clientService2", ClientServiceImpl.class);
        service.printMsg();
        //System.out.println(service);
        ClientServiceImpl2 service2 = context.getBean("clientService3", ClientServiceImpl2.class);
        service2.printMsg();
        //System.out.println(service2);
        String intstanceString = context.getBean("intstanceString", String.class);
        System.out.println(intstanceString);
        String intstanceString2 = context.getBean("intstanceString", String.class);
        System.out.println(intstanceString2);
        System.out.println("--------------");

        context.close();
    }
}
