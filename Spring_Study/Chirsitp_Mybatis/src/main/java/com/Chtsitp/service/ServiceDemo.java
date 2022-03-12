package com.Chtsitp.service;

import com.Chtsitp.dao.UserMapper;
import com.Chtsitp.dao.impl.UseMapperImpl;
import com.Chtsitp.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName ServiceDemo
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/29 18:59
 * @Version 1.0
 **/

public class ServiceDemo {
    public static void main(String[] args) throws IOException {
        /*
        //创建dao层，当前dao层是手动创建的
        UserMapper userMapper = new UseMapperImpl();
        List<User> all = userMapper.findAll();
        System.out.println(all);
        */
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    }
}
