package com.test;

import com.Chtsitp.dao.UserMapper;
import com.Chtsitp.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MapperTest
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/29 21:15
 * @Version 1.0
 **/

public class MapperTest {
    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件user
        User condition = new User();
        condition.setId(1);
        condition.setUsername("盛翔宇01");
        condition.setPassword("123");

        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);

    }

    @Test
    public void test02() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟ids的数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }

    @Test
    public void test03() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //设置分页相关的参数  当前页和每页的条数
        PageHelper.startPage(1, 3);
        List<User> userList = mapper.findAll();
        for (User user:
             userList) {
            System.out.println(user);
        }

        //获取分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页:" + pageInfo.getPageNum());
        System.out.println("每页显示的条数:" + pageInfo.getPageSize());
        System.out.println("总条数:" + pageInfo.getTotal());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("前一页:" + pageInfo.getPrePage());
        System.out.println("后一页:" + pageInfo.getNextPage());
        System.out.println("是否是第一页:" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页:" + pageInfo.isIsLastPage());
        sqlSession.close();
    }
}
