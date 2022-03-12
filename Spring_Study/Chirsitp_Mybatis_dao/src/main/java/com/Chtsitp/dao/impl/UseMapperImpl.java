package com.Chtsitp.dao.impl;

import com.Chtsitp.dao.UserMapper;
import com.Chtsitp.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName UseMapperImpl
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/29 12:36
 * @Version 1.0
 **/
public class UseMapperImpl implements UserMapper {
    @Override
    public List<User> findAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        return userList;
    }
}
