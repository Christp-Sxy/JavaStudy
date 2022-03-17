package com.test;

import com.Christp.domain.Info;
import com.Christp.domain.Order;
import com.Christp.domain.Users;
import com.Christp.mapper.OrderMapper;
import com.Christp.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName OrderTest
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/30 20:31
 * @Version 1.0
 **/

public class OrderTest {
    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> userList = mapper.findAll();
        for (Order user :
                userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Info> infoList = mapper.findAll();
        for (Info user :
                infoList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test03() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Users> usersList = mapper.findUserAndRoleAll();
        for (Users us :
                usersList) {
            System.out.println(us);
        }
        sqlSession.close();
    }
}
