package com.skyline.Mapper;

import com.skyline.Entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface userMapper {

    /**/
    @Select("SELECT * FROM sc_user WHERE uaccount = #{uaccount} and upassword = #{upassword}")
    User selectByAP(@Param("uaccount") String uaccount,@Param("upassword") String upassword);

    /**/
    @Select("SELECT COUNT(*) FROM sc_user WHERE uaccount = #{uaccount}")
    int selectByAccount(@Param("uaccount") String uaccount);

    /**/
    @Insert("INSERT INTO sc_user(uaccount, upassword, islogin) VALUES(#{uaccount}, #{upassword}, 1)")
    int insertUser(@Param("uaccount") String uaccount,@Param("upassword") String upassword);

    /**/
    @Update("UPDATE sc_user SET islogin = 0 WHERE uid = #{uid}")
    int updatelogin(@Param("uid")Integer uid);

}
