package com.skyline.Controller;

import com.skyline.Common.Result;
import com.skyline.Entity.Admin;
import com.skyline.Service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private adminService adminService;

    @RequestMapping("/login")
    public Result adminLogin(String account,String password){

        Admin admin = adminService.loginAdmin(account, password);

        if (admin != null){
            return new Result().success(admin);
        }else{
            return new Result().error("该管理员不存在");
        }
    }

    @RequestMapping("/checkaccount")
    public Result checkAccount(String account){
        int flag = adminService.checkAdminAccount(account);
        if (flag == 0){
            return new Result().success();
        }else{
           return new Result().error("该账号已存在！");
        }
    }

    @RequestMapping("/register")
    public Result register(String account, String password) {

        int flag = adminService.registerAdmin(account, password);
        if (flag == 1) {
            return new Result().success();
        } else {
            return new Result().error("注册失败！");
        }
    }

    @RequestMapping("/loginoff")
    public Result loginOff(@RequestParam("id") Integer aid){
        int flag = adminService.loginOff(aid);
        if(flag != 0){
            return new Result().success();
        }else{
            return new Result().error();
        }
    }


}
