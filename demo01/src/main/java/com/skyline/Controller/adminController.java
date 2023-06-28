package com.skyline.Controller;

import com.skyline.Common.Result;
import com.skyline.Entity.Admin;
import com.skyline.Service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/admin")
public class adminController {

    /*管理员业务层接口*/
    @Autowired
    private adminService adminService;

    /**
     * 登录后台管理系统（管理员）
     *
     * @param account  管理员账号
     * @param password 密码
     * @return
     */
    @RequestMapping("/login")
    public Result adminLogin(String account, String password) {

        Admin admin = adminService.loginAdmin(account, password);

        if (admin != null) {
            return new Result().success(admin);
        } else {
            return new Result().error("该管理员不存在");
        }
    }

    /**
     * 检查账号是否存在
     *
     * @param account 管理员账号
     * @return
     */
    @RequestMapping("/checkaccount")
    public Result checkAccount(String account) {
        int flag = adminService.checkAdminAccount(account);
        if (flag == 0) {
            return new Result().success();
        } else {
            return new Result().error("该账号已存在！");
        }
    }

    /**
     * 注册管理员
     *
     * @param account  账号
     * @param password 密码
     * @return
     */
    @RequestMapping("/register")
    public Result register(String account, String password) {

        int flag = adminService.registerAdmin(account, password);
        if (flag == 1) {
            return new Result().success();
        } else {
            return new Result().error("注册失败！");
        }
    }


    /**
     * 注销登录
     *
     * @param aid 管理员id
     * @return
     */
    @RequestMapping("/logout")
    public Result loginOff(@RequestParam("id") Integer aid) {
        int flag = adminService.loginOff(aid);
        if (flag != 0) {
            return new Result().success();
        } else {
            return new Result().error();
        }
    }


    /**
     * 修改管理员信息
     *
     * @param admin 管理员信息
     * @return
     */
    @RequestMapping("/updateadmin")
    public Result updateAdmin(@RequestBody Admin admin) {
        int flag = adminService.updateAdmin(admin);
        if (flag != 0) {
            System.out.println(flag);
            return new Result().success("修改成功");
        } else {
            return new Result().error("修改失败");
        }
    }


}
