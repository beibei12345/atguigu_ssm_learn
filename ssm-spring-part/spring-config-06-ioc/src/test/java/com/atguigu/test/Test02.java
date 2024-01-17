package com.atguigu.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.config.JavaConfiguration;
import com.atguigu.ioc_02.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test02 {
    @Test
    public void test01(){
        // AnnotationConfigApplicationContext-IOC容器对象
        ApplicationContext iocContainerAnnotation =
                new AnnotationConfigApplicationContext();
//外部设置配置类
        ((AnnotationConfigApplicationContext) iocContainerAnnotation).register(JavaConfiguration.class);
//刷新后方可生效！！
        ((AnnotationConfigApplicationContext) iocContainerAnnotation).refresh();

        String strBean = iocContainerAnnotation.getBean("strBean", String.class);
        System.out.println(strBean);

        DruidDataSource dataSource3 = iocContainerAnnotation.getBean("dataSource3", DruidDataSource.class);
        System.out.println(dataSource3.getUsername());

        JavaBean javaBean = iocContainerAnnotation.getBean("javaBean", JavaBean.class);
        System.out.println(javaBean);

        String ano = iocContainerAnnotation.getBean("ano", String.class);
        System.out.println(ano);

        ((AnnotationConfigApplicationContext) iocContainerAnnotation).close();
    }
}
