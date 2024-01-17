package com.atguigu.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void testForJava(){

        /**
         * JdbcTemplate 简化数据库的crud 不提供连接池
         *    |
         * DruidDataSource 负责连接的创建和数据库驱动的注册等等
         */

        //0.创建一个连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql:///studb"); //url地址
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); //jdbc驱动
        dataSource.setUsername("root"); //账号
        dataSource.setPassword("root"); //密码

        //1.实例化对象即可
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(dataSource);

        //2.调用方法即可
        // jdbcTemplate.update() DDL DML DCL ... 非查询语句
        // jdbcTemplate.queryForObject()  DQL 查询单个对象
        // jdbcTemplate.query() DQL 查询集合


    }

    /**
     * 通过ioc容器读取配置的JdbcTemplate组件
     */
    @Test
    public void testForIoCInsert(){
        //1.创建ioc容器
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");
        //2.获取jdbcTemplate组件

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        String sql = "insert into students(id, name, gender, age, class) values(?,?,?,?,?)";
        int rows = jdbcTemplate.update(sql, 9, "二狗子", "男", 18, "三年二班");
        System.out.println(rows);
    }

    @Test
    public void testForIoCQuery(){
        //1.创建ioc容器
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");
        //2.获取jdbcTemplate组件

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        String sql = "select * from students where id = ?";
        Student student1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setGender(rs.getString("gender"));
            student.setClasses(rs.getString("class"));
            return student;
        }, 1);
        System.out.println(student1);
    }

    @Test
    public void testForIoCQueryAll(){
        //1.创建ioc容器
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-01.xml");
        //2.获取jdbcTemplate组件

        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        String sql = "select id, name, gender, age, class as classes from students";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(studentList);
    }
}
