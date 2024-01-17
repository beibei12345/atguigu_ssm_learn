package com.atguigu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // service mapper层的ioc容器的配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }


    // 设置我们项目对应的配置 springmvc controller
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    // 配置springmvc内部自带servlet 的访问地址 !
    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/"};
    }
}
