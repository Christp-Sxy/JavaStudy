package com.Christp.mapper;

import com.Christp.domain.Info;
import com.Christp.domain.Order;
import com.Christp.domain.Users;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Christp
 * @Date 2021/11/30 18:52
 * @Version 1.0
 **/

public interface UserMapper {
    public List<Info> findAll();

    public List<Users> findUserAndRoleAll();
}
