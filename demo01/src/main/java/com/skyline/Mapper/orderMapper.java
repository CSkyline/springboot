package com.skyline.Mapper;

import com.skyline.Entity.Order;
import com.skyline.Util.OrderResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface orderMapper {

    @Select("SELECT * FROM sc_order WHERE uid = #{uid}")
    List<Order> selectByUid(@Param("uid") Integer uid);

    List<OrderResult> findOrderByOidAddTimeAndAccount(Integer oid, String addtime, String account);


}
