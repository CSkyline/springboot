package com.skyline.Mapper;

import com.skyline.Entity.Collect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface collectMapper {

    /**/
    @Select("SELECT * FROM sc_collect WHERE uid=#{uid}")
    List<Collect> AselectByUid(@Param("uid") Integer uid);

    //    /*deng*/
    @Select("SELECT * FROM sc_collect JOIN (SELECT pid,pname,imgstr FROM sc_product) AS sc_p USING(pid) WHERE uid=#{uid}")
    List<Collect> selectByUid(@Param("uid") Integer uid);

    @Insert("INSERT INTO sc_collect VALUES (#{id},#{uid},#{pid})")
    void insertCollection(@Param("id") Integer id, @Param("uid") Integer uid, @Param("pid") Integer pid);

    @Delete("DELETE FROM sc_collect WHERE id=#{id}")
    void deleteCollection(@Param("id") Integer id);

}
