package com.skyline.Service;

import com.skyline.Entity.User;

import java.util.List;


public interface userService {

    int updatePssword(User user);

    User selectByUid(Integer uid);

    /**/
    User loginUser(String account, String password);//通过账号和密码查询

    /**/
    int checkAccount(String account);//通过账号查询

    int updateUser(User u);

    /**/
    int registerUser(User u);

    /**/
    int updateLogin(Integer uid);

    int userNum();

    List<User> selectUser();

    List<User> selectUserByAccountId(Integer uid, String account);

    int delByUid(Integer uid);

    int deleteUserByUids(List<Integer> uidList);

    User selectAccountByUid(Integer uid);

    /**/
    int insertUser(String account, String password);

    /**/
    int updatelogin(Integer uid);
}
