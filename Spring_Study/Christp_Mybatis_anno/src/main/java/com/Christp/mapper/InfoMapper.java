package com.Christp.mapper;

import com.Christp.domain.Info;
import org.apache.ibatis.annotations.Select;

public interface InfoMapper {
    @Select("select * from info where id=#{id}")
    public Info findById(int id);
}
