package com.Christp.demo;

import com.Christp.service.UserService;
import com.Christp.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/25 19:08
 * @Version 1.0
 **/

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*
        两种方式的getBean，第一种允许多个相同类型的bean，第二种只允许一个
         */
        //UserService userService = (UserService) app.getBean("userService");
        UserService userService = app.getBean(UserService.class);
        userService.save();

        /*
        会有空指针错误
        UserService userService = new UserServiceImpl();
        userService.save();
        */
    }
}
