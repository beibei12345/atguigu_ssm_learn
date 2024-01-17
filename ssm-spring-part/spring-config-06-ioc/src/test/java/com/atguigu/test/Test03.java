package com.atguigu.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.config.JavaConfiguration;
import com.atguigu.ioc_01.NeedScanBean;
import com.atguigu.ioc_02.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test03 {
    @Test
    public void test01(){
        // AnnotationConfigApplicationContext-IOC容器对象
        ApplicationContext iocContainerAnnotation =
                new AnnotationConfigApplicationContext();
//外部设置配置类
        ((AnnotationConfigApplicationContext) iocContainerAnnotation).register(JavaConfiguration.class);
//刷新后方可生效！！
        ((AnnotationConfigApplicationContext) iocContainerAnnotation).refresh();

        String testStrBean = iocContainerAnnotation.getBean("testStrBean", String.class);
        System.out.println(testStrBean);

        NeedScanBean needScanBean = iocContainerAnnotation.getBean("needScanBean", NeedScanBean.class);
        System.out.println(needScanBean);

        ((AnnotationConfigApplicationContext) iocContainerAnnotation).close();
    }
}
