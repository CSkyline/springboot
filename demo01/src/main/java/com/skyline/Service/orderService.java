package com.skyline.Service;

import com.skyline.Entity.Order;
import com.skyline.Request.OrderResult;

import java.util.List;

public interface orderService {

    List<Order> selectOrderByUid(Integer Uid);

    //    List<OrderResult> findOrderByOidAddTimeAndAccount(Integer oid, String addtime, String account);

    int orderNum();

    double totalMoney();

    List<OrderResult> orderAllList();

    List<OrderResult> initOrderResult(List<Order> oList);

    List<OrderResult> vagueSelectById(Integer oid);

    int delOrderByOid(Integer oid);

    List<Order> selectByUid(Integer uid);

}
