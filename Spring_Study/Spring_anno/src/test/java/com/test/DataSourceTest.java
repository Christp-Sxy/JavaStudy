package com.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @ClassName DataSourceTest
 * @Description TODO
 * @Author com.com.Christp
 * @Date 2021/11/25 21:34
 * @Version 1.0
 **/

public class DataSourceTest {
    @Test
    //测试手动创建c3p1数据源
    public void test01() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///study?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("sxy200296");
        Connection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }

    @Test
    public void test02() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///study?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("sxy200296");
        Connection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }

    @Test
    //测试手动创建c3p1数据源(加载配置文件形式)
    public void test03() throws Exception {
        /*
        读取的起始路径是类加载路径
        需要的参数为文件的基本名称也就是不含文件形式的
         */
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        Connection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }

    @Test
    //测试手动创建c3p1数据源(Spring形式)
    public void test04() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = app.getBean(DataSource.class);
        Connection con = dataSource.getConnection();
        System.out.println(con);
        con.close();
    }
}
