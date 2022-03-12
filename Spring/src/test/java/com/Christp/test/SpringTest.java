package com.Christp.test;

import com.Christp.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Christp
 * @version 1.0
 * @ClassName SpringTest
 * @Description TODO
 * @date 2021/11/24 22:00
 */

public class SpringTest {
    @Test
    public void test01(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        System.out.println(userDao);

    }
}