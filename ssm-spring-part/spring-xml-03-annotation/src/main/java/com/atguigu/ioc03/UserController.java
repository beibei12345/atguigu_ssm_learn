package com.atguigu.ioc03;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

//    @Autowired
//    @Qualifier("userServiceImpl")

    @Resource
    private UserService userService1;

//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    public void show(){
        System.out.println(userService1.show());
    }
}
