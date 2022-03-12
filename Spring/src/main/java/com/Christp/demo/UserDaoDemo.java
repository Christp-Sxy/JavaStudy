package com.Christp.demo;


import com.Christp.dao.UserDao;
import com.Christp.dao.impl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Christp
 * @version 1.0
 * @ClassName UserDaoDemo
 * @Description TODO
 * @date 2021/11/24 21:51
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.save();
    }
}