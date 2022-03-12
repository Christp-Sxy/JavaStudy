package com.Christp.mapper;

import com.Christp.domain.Info;
import com.Christp.domain.Order;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName OrderMapper
 * @Description TODO
 * @Author Christp
 * @Date 2021/12/4 13:47
 * @Version 1.0
 **/

public interface OrderMapper {
    @Select("select *, u.uid from info o, orders u where u.uid=o.id1")
    @Results({
            @Result(column = "uid", property = "uid"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "info",//要封装的属性名称
                    column = "id1",//根据哪个字段去查询user表中的数据
                    javaType = Info.class,//要封装的实体类型
                    //select属性，代表查询哪个接口的方法获得数据
                    one = @One(select = "com.Christp.mapper.InfoMapper.findById")
            )
    })
    public List<Order> findAll();
}
