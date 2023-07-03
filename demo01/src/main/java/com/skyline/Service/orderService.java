package com.skyline.Service;

import com.skyline.Entity.Order;
import com.skyline.Util.OrderResultUtil;

import java.util.List;

public interface orderService {

    List<Order> selectOrderByUid(Integer Uid);

    List<OrderResultUtil> findOrderByOidAddTimeAndAccount(Integer oid, String addtime, String account);
}
