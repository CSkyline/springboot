package com.skyline.Mapper;

import com.skyline.Entity.Admin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface adminMapper {

    @Select("SELECT * FROM sc_admin WHERE aaccount = #{aaccount} AND apassword = #{apassword}")
    Admin selectByAP(@Param("aaccount") String account,@Param("apassword") String password);


    @Select("SELECT COUNT(*) FROM sc_admin WHERE aaccount = #{aaccount}")
    int selectByAccount(@Param("aaccount") String account);

    @Insert("INSERT INTO sc_admin (aid, aaccount,apassword,aname,atel,aimg,islogin) VALUES (#{aid},#{aaccount},#{apassword},#{aname},#{atel},#{aimg},#{islogin})")
    int insertAdmin(Admin admin);

    int updateByAid(Admin admin);
}
