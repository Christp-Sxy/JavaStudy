package com.test;

import com.Christp.domain.Info;
import com.Christp.domain.Order;
import com.Christp.domain.User;
import com.Christp.mapper.OrderMapper;
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

public class MyBatisTest2 {
    OrderMapper mapper;

    @Before
    public void Before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void testFindAll(){
        List<Order> all = mapper.findAll();
        for (Order in:
             all) {
            System.out.println(in);
        }
    }
}
