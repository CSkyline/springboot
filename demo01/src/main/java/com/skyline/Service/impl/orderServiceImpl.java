package com.skyline.Service.impl;

import com.skyline.Entity.Order;
import com.skyline.Mapper.orderMapper;
import com.skyline.Service.orderService;
import com.skyline.Util.OrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderServiceImpl implements orderService {

    @Autowired
    private orderMapper orderMapper;

    @Override
    public List<Order> selectOrderByUid(Integer id) {
        try {
            List<Order> orderlist = orderMapper.selectByUid(id);
            return orderlist;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * @param oid
     * @param
     * @param account
     * @return List<OrderResult> findOrderByOidAddTimeAndAccount(Integer oid, String addtime, String account);
     */
    @Override
    public List<OrderResult> findOrderByOidAddTimeAndAccount(Integer oid, String addtime, String account) {
        try {
            List<OrderResult> oRList = orderMapper.findOrderByOidAddTimeAndAccount(oid, addtime, account);
            return oRList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
