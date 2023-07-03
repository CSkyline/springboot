package com.skyline.Mapper;

import com.skyline.Entity.Order;
import com.skyline.Util.OrderResultUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface orderMapper {

    @Select("SELECT * FROM sc_order WHERE uid = #{uid}")
    List<Order> selectByUid(@Param("uid") Integer uid);

    List<OrderResultUtil> findOrderByOidAddTimeAndAccount(Integer oid, String addtime, String account);


    /**
     * 查询order表记录数量
     * @return
     */
    @Select("SELECT COUNT(*) FROM sc_order")
    int selectOrderNum();

    /**
     * 查询order表price字段总和
     * @return
     */
    @Select("SELECT SUM(price) FROM sc_order;")
    double selectPriceSum();
}
