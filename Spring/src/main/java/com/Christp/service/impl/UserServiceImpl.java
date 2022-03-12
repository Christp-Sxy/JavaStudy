package com.Christp.service.impl;

import com.Christp.dao.UserDao;
import com.Christp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/25 19:05
 * @Version 1.0
 **/



public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

        /*
        public void setUserDao(UserDao userDao) {
            this.userDao = userDao;
        }
        */
    @SuppressWarnings("AlibabaRemoveCommentedCode")
    @Override
    public void save() {
        userDao.save();
    }


}
