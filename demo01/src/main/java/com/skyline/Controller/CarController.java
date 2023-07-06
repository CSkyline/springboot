package com.skyline.Controller;

import com.skyline.Entity.Order;
import com.skyline.Entity.UserCar;
import com.skyline.Request.Result;
import com.skyline.Service.UserCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    UserCarService userCarService;

    @RequestMapping("/addPd")
    public Result addProduct(UserCar pd) {


        int flag = userCarService.Caradd(pd);

        if (flag == 1) {

            return Result.success();

        } else {
            return Result.error("加入购物车失败！！");
        }
    }

    @RequestMapping("/deletePd")
    public Result deleteproduct(int id) {


        int flag = userCarService.Cardele(id);

        if (flag == 1) {

            return Result.success();
        } else {

            return Result.error("该商品不存在！！");
        }

    }

    @RequestMapping("/orderhave")
    public Result OrderHave(List<Order> orders) {

        int flag = userCarService.OrderCreate(orders);

        if (flag == 1) {
            return Result.success("创建订单成功!!");
        } else {

            return Result.error("订单创建失败！！");
        }

    }

    @RequestMapping("/carproduct")
    public Result carItems() {

        List<UserCar> items = userCarService.CarProduct();
        if (items.isEmpty()) {
            return Result.error("获取购物车失败！！");


        } else {

            return Result.success(items);
        }
    }

}
