//package com.Chtsitp.handler.Date;
//
//import org.apache.ibatis.type.BaseTypeHandler;
//import org.apache.ibatis.type.JdbcType;
//
//import java.sql.*;
//
///**
// * @ClassName TypeHandler
// * @Description TODO
// * @Author Christp
// * @Date 2021/11/30 12:36
// * @Version 1.0
// **/
//
//public class TypeHandler extends BaseTypeHandler<Date> {
//    //将 java 类型转换成数据库需要的类型
//    @Override
//    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
//        long time = date.getTime();
//        //i是数据的位置，time是转换的变量
//        preparedStatement.setLong(i, time);
//    }
//
//    //将数据库需要的类型转换成 java 类型
//    @Override
//    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
//        /*
//        * resultSet是查询的结果集
//        * string是需要转换的字段
//        * */
//
//        //获得的结果集中需要的数据(long)转换成Date类型
//        long aLong = resultSet.getLong(s);
//        return new Date(aLong);
//    }
//
//    //将 java 类型转换成数据库需要的类型
//    @Override
//    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
//        long aLong = resultSet.getLong(i);
//        return new Date(aLong);
//    }
//
//    //将数据库需要的类型转换成 java 类型
//    @Override
//    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
//        long aLong = callableStatement.getLong(i);
//        return new Date(aLong);
//    }
//    //之后去注册类型处理器
//}
