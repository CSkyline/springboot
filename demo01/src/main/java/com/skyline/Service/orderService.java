package com.skyline.Service;

import com.skyline.Entity.Order;

public interface orderService {

    Order selectByUid(Integer uid);
}
