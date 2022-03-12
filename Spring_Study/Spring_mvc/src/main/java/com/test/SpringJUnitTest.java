package com.test;

import com.Christp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName SpringJUnitTest
 * @Description TODO
 * @Author com.com.Christp
 * @Date 2021/11/27 15:59
 * @Version 1.0
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJUnitTest {
    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        userService.save();
    }
}
