package com.test;

import com.Christp.domain.User;
import com.Christp.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MyBatisTest
 * @Description TODO
 * @Author Christp
 * @Date 2021/12/4 13:23
 * @Version 1.0
 **/

public class MyBatisTest {
    UserMapper mapper;

    @Before
    public void Before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void SaveTest() {
        User user = new User();
        user.setUsername("Christp");
        user.setPassword("123456");
        mapper.save(user);
    }

    @Test
    public void UpdateTest() {
        User user = new User();
        user.setUsername("Christp");
        user.setPassword("1246");
        mapper.update(user);
    }

    @Test
    public void DeleteTest() {
        mapper.delete(6);
    }

    @Test
    public void SelectByIdTest() {
        User user = mapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void SelectAllTest() {
        List<User> userList = mapper.findAll();
        for (User user :
                userList) {
            System.out.println(user);
        }
    }
}
