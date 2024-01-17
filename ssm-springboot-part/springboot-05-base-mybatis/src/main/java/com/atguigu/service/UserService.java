package com.atguigu.service;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * projectName: com.atguigu.service
 *
 * @author: 赵伟风
 * description:
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryAll(){
        return userMapper.queryAll();
    }

    @Transactional
    public void delete( ){
        userMapper.delete(1);
        int i = 1/0;
        userMapper.delete(2);
    }
}
