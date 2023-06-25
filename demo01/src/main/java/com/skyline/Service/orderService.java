package com.skyline.Service;

import com.skyline.Entity.Order;

import java.util.List;

public interface orderService {

    List<Order> selectOrderByUid(Integer Uid);
}
