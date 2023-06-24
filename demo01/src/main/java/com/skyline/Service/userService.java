package com.skyline.Service;

import com.skyline.Entity.User;
import org.apache.ibatis.annotations.Param;

public interface userService {

    /**/
    User selectByAP(String uaccount,String upassword);//通过账号和密码查询

    /**/
    int selectByAccount(String uaccount);//通过账号查询

    /**/
    int insertUser(String uaccount, String upassword);

    /**/
    int updatelogin(Integer uid);
}
