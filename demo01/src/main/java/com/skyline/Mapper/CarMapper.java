package com.skyline.Mapper;


import com.skyline.Entity.Order;
import com.skyline.Entity.UserCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {

    void addProducts(UserCar pd);

    void deleteProducts(int id);

    void insertOrder(Order orders);

    List<UserCar> selectProduct();


}
