package com.skyline.Service.impl;

import com.skyline.Entity.Admin;
import com.skyline.Mapper.adminMapper;
import com.skyline.Service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServiceImpl  implements adminService {

    @Autowired
    private adminMapper adminMapper;

    @Override
    public Admin loginAdmin(String account, String password) {
        try {
            Admin admin = adminMapper.selectByAP(account,password);
            admin.setIslogin(true);
            adminMapper.updateByAid(admin);
            return admin;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int checkAdminAccount(String account) {
        try {
            int flag = adminMapper.selectByAccount(account);
            return flag;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int registerAdmin(String account,String password) {
        try {
            /*有点怪怪的*/
            Admin admin = new Admin();
            admin.setAaccount(account);
            admin.setApassword(password);
            adminMapper.insertAdmin(admin);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int loginOff(Integer aid) {
        try {
            Admin admin = new Admin();
            admin.setAid(aid);
            admin.setIslogin(false);
            adminMapper.updateByAid(admin);
            return 1;
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }


}
