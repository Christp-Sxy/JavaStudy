package com.Christp.service.impl;

import com.Christp.dao.UserDao;
import com.Christp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author com.com.Christp
 * @Date 2021/11/26 21:47
 * @Version 1.0
 **/

//<bean id="userService" class="com.com.com.Christp.service.impl.UserServiceImpl">
//@Component("userService")
//业务层(Service)用Service
@Service("userService")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")//为下面的基础属性参数进行赋值，可以调用xml中调用的配置文件
    private String driver;


    //<property name="userDao" ref="userDao"/>
//    @Autowired//按照数据类型从Spring容器中进行匹配
//    @Qualifier("userDao")//是按照id的值从容器中进行匹配，但是此处的@Qualifier需要结合@Autowired一起使用
    @Resource(name = "userDao")//相当于@Autowired+@Qualifier
    private UserDao userDao;
    /*
    使用xml需要使用setter方法
    */
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }
}
