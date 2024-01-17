package com.atguigu.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.config.JavaConfiguration;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;

@SpringJUnitConfig(value = {JavaConfiguration.class})
public class Test01 {

    @Autowired
    private String strBean;

    @Autowired
    @Qualifier("ergouzi")
    private DruidDataSource dataSource;

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate2;

    @Test
    public void test01(){
        System.out.println(strBean);
        System.out.println(dataSource.getUsername());
        System.out.println(jdbcTemplate);
        System.out.println(jdbcTemplate2);
    }
}
