package com.atguigu.test;

import com.atguigu.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {
    @Autowired
    private JwtHelper jwtHelper;

    @Test
    public void test01(){
        String token = jwtHelper.createToken(21432L);
        System.out.println();
        System.out.println("token = " + token);
        int userId = jwtHelper.getUserId(token).intValue();
        System.out.println("userId = " + userId);
        boolean expiration = jwtHelper.isExpiration(token);
        System.out.println("expiration = " + expiration);
        System.out.println();
    }
}
