package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sxy
 */
@Controller
//@RequestMapping("/user")//请求映射
@RequestMapping("/s")
public class UserController {
    // 请求地址  http://localhost:8080/user/quick
//    @RequestMapping(value="/quick",method = RequestMethod.GET,params = {"username"})
    @RequestMapping("/b")
    public String save() {
        System.out.println("Controller save running....");
        return "success.jsp";
    }

}
