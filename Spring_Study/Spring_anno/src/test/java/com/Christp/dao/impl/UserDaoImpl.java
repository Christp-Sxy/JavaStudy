package com.Christp.dao.impl;

import com.Christp.dao.UserDao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author com.com.Christp
 * @Date 2021/11/26 21:44
 * @Version 1.0
 **/


//<bean id="userDao" class="com.com.com.Christp.dao.impl.UserDaoImpl"/>
//@Component("userDao")
//仓库(DAO)用@Repository
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("It's running");
    }
}
