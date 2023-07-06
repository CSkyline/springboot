package com.skyline.Mapper;

import com.skyline.Entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface userMapper {

    @Update("UPDATE sc_user SET password = #{password} WHERE uid = #{uid}")
    int updatePassword(String password, Integer uid);

    @Select("SELECT * FROM sc_user WHERE uid =#{uid}")
    User selectByUid(@Param("uid") Integer uid);

    /**/
    @Select("SELECT * FROM sc_user WHERE account = #{account} and password = #{password}")
    User selectByAP(@Param("account") String account, @Param("password") String password);

    /**/
    @Select("SELECT COUNT(*) FROM sc_user WHERE account = #{account}")
    int selectByAccount(@Param("account") String account);

    @Update("UPDATE sc_user SET account = #{account}, password = #{password}, username = #{username}, userimg = #{userimg}, phone = #{phone}, islogin = #{islogin} WHERE uid = #{uid}")
    int updateUser(User u);

    /**/
    int AinsertUser(User user);

    /*通过uid更新user表*/
    int updateUserByUid(User user);

    /**
     * 查询user表记录数量
     * @return
     */
    @Select("SELECT COUNT(*) FROM sc_user")
    int selectUserNum();

    @Select("SELECT * FROM sc_user")
    List<User> selectUser();

    List<User> selectByAccountId(Integer uid, String account);

    @Delete("DELETE FROM sc_user WHERE uid = #{uid}")
    int deleteByPid(Integer uid);


    int deleteUserByIds(List<Integer> uids);

    @Select("SELECT account,phone FROM sc_user WHERE uid = #{uid}")
    User selectAccountByUid(Integer uid);

    /**/
    @Insert("INSERT INTO sc_user(account, password, islogin) VALUES(#{account}, #{password}, 1)")
    int insertUser(@Param("account") String account, @Param("password") String password);

    /**/
    @Update("UPDATE sc_user SET islogin = 0 WHERE uid = #{uid}")
    int updatelogin(@Param("uid") Integer uid);


}
