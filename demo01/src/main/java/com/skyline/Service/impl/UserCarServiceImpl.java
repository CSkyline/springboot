package com.skyline.Service.impl;

import com.skyline.Entity.Order;
import com.skyline.Entity.UserCar;
import com.skyline.Mapper.CarMapper;
import com.skyline.Service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCarServiceImpl implements UserCarService {

    @Autowired
    CarMapper carMapper;

    @Override
    public int Caradd(UserCar pd) {
        try {
            carMapper.addProducts(pd);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("加入购物车失败！！");
            return 0;
        }
    }

    @Override
    public int Cardele(int id) {
        try {
            carMapper.deleteProducts(id);
            System.out.println();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("该商品不存在！！");
            return 0;
        }
    }

    @Override
    public int OrderCreate(List<Order> orders) {
        try {
            for (Order order : orders) {
                carMapper.insertOrder(order);
            }
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }


    @Override
    public List<UserCar> CarProduct() {
        try {
            List<UserCar> list = carMapper.selectProduct();
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}


