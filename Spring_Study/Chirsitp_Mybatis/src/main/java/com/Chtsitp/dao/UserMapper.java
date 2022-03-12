package com.Chtsitp.dao;

import com.Chtsitp.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author Christp
 */
public interface UserMapper {
    public List<User> findByCondition(User user);
    public List<User> findByIds(List<Integer> ids);
    public List<User> findAll();
}
