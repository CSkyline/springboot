package com.skyline.Mapper;

import com.skyline.Entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface orderMapper {

    @Select("SELECT * FROM sc_order WHERE uid = #{uid}")
    Order selectByUid(@Param("uid") Integer uid);
}
