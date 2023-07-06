package com.skyline.Controller;

import com.skyline.Request.OrderResult;
import com.skyline.Request.Result;
import com.skyline.Service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/6/27 15:05]
 */
@RestController
@RequestMapping("/order")
public class orderController {

    @Autowired
    orderService orderService;

    @RequestMapping("/list")
    public Result orderList() {
        List<OrderResult> orderResultList = orderService.orderAllList();
        if (orderResultList.isEmpty()) {
            return Result.error();
        } else {
            return Result.success(orderResultList);
        }
    }

    @RequestMapping("/oid")
    public Result vagueSelectById(Integer oid) {
        List<OrderResult> oRList = orderService.vagueSelectById(oid);
        if (oRList.isEmpty()) {
            return Result.error();
        } else {
            return Result.success(oRList);
        }
    }

    @RequestMapping("/del")
    public Result delOrderByOid(Integer oid) {
        if (oid == null) {
            return Result.error("oid为空");
        } else {
            int flag = orderService.delOrderByOid(oid);
            if (flag == 0) {
                return Result.error();
            } else {
                return Result.success("删除成功");
            }
        }
    }
}
