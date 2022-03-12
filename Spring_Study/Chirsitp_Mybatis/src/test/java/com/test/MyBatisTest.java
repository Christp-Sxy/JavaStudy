package com.test;

import com.Chtsitp.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MyBatisTest
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/28 21:05
 * @Version 1.0
 **/

/*
* MyBatis默认事务是不提交的！！！
* */

public class MyBatisTest {
    @Test
    public void test01() throws IOException {
        //获得配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数:namespace.id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {
        //模拟User对象
        User user = new User();
        user.setUsername("老实人");
        user.setPassword("123456");

        //获得配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数:namespace.id
        int count = sqlSession.insert("userMapper.save", user);
        //打印数据
        System.out.println(count);
        //执行更新事务时，要执行提交操作
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test03() throws IOException {
        //模拟User对象
        User user = new User();
        user.setId(4);
        user.setUsername("老阴比");
        user.setPassword("250");

        //获得配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数:namespace.id
        int count = sqlSession.update("userMapper.update", user);
        //打印数据
        System.out.println(count);
        //执行更新事务时，要执行提交操作
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test04() throws IOException {

        //获得配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数:namespace.id
        int count = sqlSession.delete("userMapper.delete", 3);
        //打印数据
        System.out.println(count);
        //执行更新事务时，要执行提交操作
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
