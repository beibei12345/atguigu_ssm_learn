package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.ioc_02.Foo;
import com.atguigu.ioc_02.JavaBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.temporal.Temporal;

@ComponentScan({"com.atguigu.ioc_01", "com.atguigu.ioc_02"})
@PropertySource("classpath:jdbc.properties")
@Import(JavaConfigurationA.class)
@Configuration
public class JavaConfiguration {
    @Value("${atguigu.url}")
    private String url;
    @Value("${atguigu.driver}")
    private String driver;
    @Value("${atguigu.username}")
    private String username;
    @Value("${atguigu.password}")
    private String password;

    @Bean("strBean")
    public String getStringBean() {
        return "JavaConfiguration{" +
                "url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "ergouzi")
    public DruidDataSource dataSource1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username + "ergouzi");
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "lvdandan")
    public DruidDataSource dataSource2(){
        //实现具体的实例化过程
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username + "lvdandan");
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DruidDataSource dataSource3(@Value("${atguigu.username}") String username,
                                       @Value("${atguigu.password}") String password,
                                       @Value("${atguigu.url}") String url,
                                       @Value("${atguigu.driver}") String driverClassName){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username + "贝贝sama");
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource1());
        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource lvdandan, DataSource ergouzi){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        System.out.println(lvdandan.hashCode());
        System.out.println(ergouzi.hashCode());
        jdbcTemplate.setDataSource(lvdandan);
        return jdbcTemplate;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("singleton")
    public JavaBean javaBean(){
        return new JavaBean();
    }

    @Bean
    public Foo foo1(){
        return new Foo();
    }

    @Bean
    public Foo foo2(){
        return new Foo();
    }

    @Bean
    public String ano(Foo foo2){
        return foo2.toString();
    }
}
