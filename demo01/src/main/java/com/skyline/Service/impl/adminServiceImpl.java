package com.skyline.Service.impl;

import com.skyline.Entity.Admin;
import com.skyline.Mapper.adminMapper;
import com.skyline.Service.adminService;
import com.skyline.Util.uploadImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class adminServiceImpl implements adminService {

    @Autowired
    private adminMapper adminMapper;

    @Override
    public Admin loginAdmin(String account, String password) {
        try {
            Admin admin = adminMapper.selectByAP(account, password);
            admin.setIslogin(true);
            adminMapper.updateByAid(admin);
            return admin;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int checkAdminAccount(String account) {
        try {
            int flag = adminMapper.selectByAccount(account);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int registerAdmin(String account, String password) {
        try {
            /*有点怪怪的*/
            Admin admin = new Admin();
            admin.setAccount(account);
            admin.setPassword(password);
            adminMapper.insertAdmin(admin);
            return 1;
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public Admin updateAdmin(Admin aPeceive) {
        try {
            Admin admin = initAdmin(aPeceive);
            adminMapper.updateByAid(admin);
            Admin aResult = adminMapper.selectByAid(aPeceive.getAid());
            return aResult;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int updatePassword(Integer aid, String oidPassword, String password) {
        int flag = adminMapper.selectPasswordByAid(aid, oidPassword);
        if (flag == 0) {
            return flag;
        } else {
            int flag_ = adminMapper.updatePassword(aid, password);
            return flag_;
        }
    }

    public Admin initAdmin(Admin aPeceive) {
        String path = "";
        if (aPeceive.getImg() != null) {
            String imgBase64 = aPeceive.getImg();
            try {
                path = uploadImgUtil.saveBase64Image(imgBase64);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        aPeceive.setImg(path);
        return aPeceive;
    }

}
