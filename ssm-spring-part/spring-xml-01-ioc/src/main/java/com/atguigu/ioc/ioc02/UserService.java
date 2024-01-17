package com.atguigu.ioc.ioc02;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    private int age;

    private String name;

    public UserService(int age , String name ,UserDao userDao) {
        this.userDao = userDao;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
