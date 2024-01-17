package com.atguigu.ioc02;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class JavaBean {

    @PostConstruct
    public void init(){
        System.out.println("JavaBean.init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JavaBean.destroy");
    }
}
