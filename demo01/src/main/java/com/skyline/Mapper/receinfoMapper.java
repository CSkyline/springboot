package com.skyline.Mapper;

import com.skyline.Entity.Receinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface receinfoMapper {

    @Select("SELECT * FROM sc_receinfo WHERE rid = #{rid}")
    Receinfo selectByid(Integer rid);
}
