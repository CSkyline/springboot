package com.skyline.Service.impl;

import com.skyline.Entity.User;
import com.skyline.Mapper.userMapper;
import com.skyline.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userMapper userMapper;

    /**/
    @Override
    public User loginUser(String account , String password) {
        try {
            User user = userMapper.selectByAP(account, password);
            user.setIslogin(1);
            return user;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int checkAccount(String account) {
        try {
            int flag = userMapper.selectByAccount(account);
            return flag;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int registerUser(String account, String password) {
        try {
            User user = new User();
            user.setAccount(account);
            user.setPassword(password);
            user.setIslogin(0);
            userMapper.insertUser(user);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int updateLogin(Integer uid) {
        try {
            User user = new User();
            user.setUid(uid);
            user.setIslogin(0);
            userMapper.updateUserByUid(user);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
}
