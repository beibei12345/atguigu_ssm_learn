package com.atguigu.service;

import com.atguigu.pojo.User;
import com.atguigu.pojo.vo.PortalVo;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-01-15 15:18:35
*/
public interface UserService extends IService<User> {
    Result login(User user);

    Result getUserInfo(String token);

    Result checkUserName(String username);

    Result regist(User user);
}
