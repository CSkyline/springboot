package com.skyline.Mapper;

import com.skyline.Entity.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface collectMapper {

    /**/
    @Select("SELECT * FROM sc_collect WHERE uid=#{uid}")
    List<Collect> selectByUid(@Param("uid") Integer uid);

}
