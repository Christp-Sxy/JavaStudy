package com.Chtsitp.dao;



import com.Chtsitp.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author Christp
 */
public interface UserMapper {
    public List<User> findAll() throws IOException;
}
