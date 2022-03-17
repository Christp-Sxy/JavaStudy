package com.Christp.dao.impl;

import com.Christp.dao.UserDao;
import com.Christp.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author Christp
 * @version 1.0
 * @ClassName UserDaoImpl
 * @Description TODO
 * @date 2021/11/24 21:18
 */
public class UserDaoImpl implements UserDao {

    private String username;
    private int age;
    private List<String> strlist;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrlist(List<String> strlist) {
        this.strlist = strlist;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println(strlist);
        System.out.println(userMap);
        System.out.println(properties);
        System.out.println(username + "--------" + age);
        System.out.println("It's running");
    }
}