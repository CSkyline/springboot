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
    public User selectByAP(String uaccount , String upassword) {
        User user = userMapper.selectByAP(uaccount, upassword);
        user.setIslogin(1);
        return user;
    }

    @Override
    public int selectByAccount(String uaccount) {
        int flag = userMapper.selectByAccount(uaccount);
        return flag;
    }

    @Override
    public int insertUser(String uaccount, String upassword) {
        try {
            userMapper.insertUser(uaccount,upassword);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            System.out.println("插入用户失败，该用户名已存在！");
            return 0;
        }
    }

    @Override
    public int updatelogin(Integer uid) {
        try {
            userMapper.updatelogin(uid);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }
}
