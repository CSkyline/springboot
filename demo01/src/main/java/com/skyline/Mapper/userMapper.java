package com.skyline.Mapper;

import com.skyline.Entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface userMapper {

    /**/
    @Select("SELECT * FROM sc_user WHERE uaccount = #{uaccount} and upassword = #{upassword}")
    User selectByAP(@Param("uaccount") String account,@Param("upassword") String password);

    /**/
    @Select("SELECT COUNT(*) FROM sc_user WHERE uaccount = #{uaccount}")
    int selectByAccount(@Param("uaccount") String account);

    /**/
    int insertUser(User user);

    /*通过uid更新user表*/
    int updateUserByUid(User user);



}
