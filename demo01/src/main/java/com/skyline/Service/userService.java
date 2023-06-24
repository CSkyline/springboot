package com.skyline.Service;

import com.skyline.Entity.User;

public interface userService {

    /**/
    User loginUser(String account,String password);//通过账号和密码查询

    /**/
    int checkAccount(String account);//通过账号查询

    /**/
    int registerUser(String account, String password);

    /**/
    int updateLogin(Integer uid);
}
