package com.skyline.Service;

import com.skyline.Entity.Order;
import com.skyline.Util.OrderResult;

import java.util.List;

public interface orderService {

    List<Order> selectOrderByUid(Integer Uid);

    List<OrderResult> findOrderByOidAddTimeAndAccount(Integer oid, String addtime, String account);
}
