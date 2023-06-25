package com.skyline.Mapper;

import com.skyline.Entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface userMapper {

    /**/
    @Select("SELECT * FROM sc_user WHERE account = #{account} and password = #{password}")
    User selectByAP(@Param("account") String account,@Param("password") String password);

    /**/
    @Select("SELECT COUNT(*) FROM sc_user WHERE account = #{account}")
    int selectByAccount(@Param("account") String account);

    /**/
    int insertUser(User user);

    /*通过uid更新user表*/
    int updateUserByUid(User user);



}
