package com.atguigu.service.impl;

import com.atguigu.utils.JwtHelper;
import com.atguigu.utils.MD5Util;
import com.atguigu.utils.Result;
import com.atguigu.utils.ResultCodeEnum;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
* @author Administrator
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-01-15 15:18:35
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User loginUser = userMapper.selectOne(queryWrapper);
        if(loginUser == null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        if(!StringUtils.isEmpty(user.getUserPwd()) &&
            loginUser.getUserPwd().equals(MD5Util.encrypt(user.getUserPwd()))){
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", token);
            return Result.ok(data);
        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {
        if(jwtHelper.isExpiration(token)){
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        int userId = jwtHelper.getUserId(token).intValue();

        User user = userMapper.selectById(userId);

        if(user != null){
            user.setUserPwd(null);
            HashMap<String, Object> data = new HashMap<>();
            data.put("loginUser", user);
            return Result.ok(data);
        }
        return Result.build(null, ResultCodeEnum.NOTLOGIN);
    }

    @Override
    public Result checkUserName(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(queryWrapper);

        if(user != null){
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        return Result.ok(null);
    }

    @Override
    public Result regist(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        Long count = userMapper.selectCount(queryWrapper);

        if(count > 0){
            return Result.build(null, ResultCodeEnum.USERNAME_USED);
        }

        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        int rows = userMapper.insert(user);
        //System.out.println("rows = " + rows);
        return Result.ok(null);
    }
}




