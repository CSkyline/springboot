package com.skyline.Service;

import com.skyline.Entity.Admin;

public interface adminService {

    Admin loginAdmin(String account, String password);

    int checkAdminAccount(String account);

    int registerAdmin(String account, String password);

    int loginOff(Integer aid);

    Admin updateAdmin(Admin aPeceive);

    int updatePassword(Integer aid, String oldPassword, String password);

}
