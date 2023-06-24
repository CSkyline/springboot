package com.skyline.Service.impl;

import com.skyline.Entity.Order;
import com.skyline.Mapper.orderMapper;
import com.skyline.Service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderServiceImpl implements orderService {

    @Autowired
    private orderMapper orderMapper;
    @Override
    public Order selectByUid(Integer uid) {
        try {
            Order order = orderMapper.selectByUid(uid);
            return order;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
