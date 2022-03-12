package com.Christp.mapper;

import com.Christp.domain.Order;
import com.Christp.domain.User;

import java.util.List;

public interface OrderMapper {
    public List<Order> findAll();
}
