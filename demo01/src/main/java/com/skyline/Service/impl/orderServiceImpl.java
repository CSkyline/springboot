package com.skyline.Service.impl;

import com.skyline.Entity.Order;
import com.skyline.Entity.Receinfo;
import com.skyline.Entity.User;
import com.skyline.Mapper.orderMapper;
import com.skyline.Mapper.productMapper;
import com.skyline.Mapper.receinfoMapper;
import com.skyline.Mapper.userMapper;
import com.skyline.Request.OrderResult;
import com.skyline.Request.productResult;
import com.skyline.Service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service


public class orderServiceImpl implements orderService {

    @Autowired
    private orderMapper orderMapper;

    @Autowired
    private userMapper userMapper;

    @Autowired
    private productMapper productMapper;

    @Autowired
    private receinfoMapper receinfoMapper;

    @Override
    public List<Order> selectOrderByUid(Integer id) {
        try {
            List<Order> orderlist = orderMapper.AselectByUid(id);
            return orderlist;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int orderNum() {
        int oNum = orderMapper.selectOrderNum();
        return oNum;
    }

    @Override
    public double totalMoney() {
        double mSum = orderMapper.selectPriceSum();
        return mSum;
    }

    @Override
    public List<OrderResult> orderAllList() {
        List<Order> oList = orderMapper.selectAll();
        List<OrderResult> orderResultList = initOrderResult(oList);
        return orderResultList;
    }

    @Override
    public List<OrderResult> initOrderResult(List<Order> oList) {
        List<OrderResult> orderResultList = new ArrayList<>();
        for (Order order : oList) {
            OrderResult tempOResult = new OrderResult();
            tempOResult.setOrder(order);
            Integer rid = order.getRid();
            Integer uid = order.getUid();
            Integer pid = order.getPid();
            User u = userMapper.selectAccountByUid(uid);
            Receinfo r = receinfoMapper.selectByid(rid);
            productResult p = productMapper.selectSingleProduct(pid);
            tempOResult.setAccount(u.getAccount());
            tempOResult.setPhone(u.getPhone());
            tempOResult.setPname(p.getPname());
            tempOResult.setReceinfo(r);
            orderResultList.add(tempOResult);
        }
        return orderResultList;
    }

    @Override
    public List<OrderResult> vagueSelectById(Integer oid) {
        List<Order> oList = orderMapper.vagueSelectById(oid);
        List<OrderResult> orderResultList = initOrderResult(oList);
        return orderResultList;
    }

    @Override
    public int delOrderByOid(Integer oid) {
        try {
            int flag = orderMapper.delOrderByOid(oid);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    /*deng*/
    @Override
    public List<Order> selectByUid(Integer uid) {
        try {
            List<Order> orders = orderMapper.selectByUid(uid);
            return orders;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


}


