package com.skyline.Service;

import com.skyline.Entity.Order;
import com.skyline.Entity.UserCar;

import java.util.List;

public interface UserCarService {
  int Caradd(UserCar pd);

  int Cardele(int id);

  int  OrderCreate(List<Order> orders);

  List<UserCar> CarProduct();

}
