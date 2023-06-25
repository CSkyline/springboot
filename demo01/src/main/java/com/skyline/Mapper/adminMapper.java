package com.skyline.Mapper;

import com.skyline.Entity.Admin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface adminMapper {

    @Select("SELECT * FROM sc_admin WHERE account = #{account} AND password = #{password}")
    Admin selectByAP(@Param("account") String account,@Param("password") String password);


    @Select("SELECT COUNT(*) FROM sc_admin WHERE account = #{account}")
    int selectByAccount(@Param("account") String account);

    @Insert("INSERT INTO sc_admin (aid, account,password,name,tel,img,islogin) VALUES (#{aid},#{account},#{password},#{name},#{tel},#{img},#{islogin})")
    int insertAdmin(Admin admin);

    int updateByAid(Admin admin);
}
