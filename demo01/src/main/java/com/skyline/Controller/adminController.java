package com.skyline.Controller;

import com.skyline.Entity.Admin;
import com.skyline.Request.Result;
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
     * @param a
     * @return
     */
    @RequestMapping("/login")
    public Result adminLogin(@RequestBody Admin a)
    //    public Result adminLogin(String account, String password)
    {
        String account = a.getAccount();
        String password = a.getPassword();
        System.out.println(account);
        System.out.println(password);
        Admin admin = adminService.loginAdmin(account, password);

        if (admin != null) {
            return Result.success(admin);
        } else {
            return Result.error("账户或密码错误！！！   ");
        }
    }

    /**
     * 检查账号是否存在
     * @param account 管理员账号
     * @return
     */
    @RequestMapping("/checkaccount")
    public Result checkAccount(String account) {
        int flag = adminService.checkAdminAccount(account);
        if (flag == 0) {
            return Result.success();
        } else {
            return Result.error("该账号已存在！");
        }
    }

    /**
     * 注册管理员
     * @param account  账号
     * @param password 密码
     * @return
     */
    @RequestMapping("/register")
    public Result register(String account, String password) {

        int flag = adminService.registerAdmin(account, password);
        if (flag == 1) {
            return Result.success();
        } else {
            return Result.error("注册失败！");
        }
    }


    /**
     * 注销登录
     * @param aid 管理员id
     * @return
     */
    @RequestMapping("/logout")
    public Result loginOff(@RequestParam("id") Integer aid) {
        int flag = adminService.loginOff(aid);
        if (flag != 0) {
            return Result.success();
        } else {
            return Result.error();
        }
    }


    /**
     * 修改管理员信息
     * @param aReceive
     * @return
     */
    @RequestMapping("/update")
    public Result updateAdmin(@RequestBody Admin aReceive) {
        Admin aResult = adminService.updateAdmin(aReceive);
        if (aResult != null) {
            return Result.success("修改成功", aResult);
        } else {
            return Result.error("修改失败!");
        }
    }

    @RequestMapping("/updatepassword")
    public Result updatePassword(@RequestBody Admin aReceive) {
        Integer aid = aReceive.getAid();
        String oldpassword = aReceive.getOldpassword();
        String password = aReceive.getPassword();
        if (aid != null && oldpassword != null && password != null) {
            int flag = adminService.updatePassword(aid, oldpassword, password);
            if (flag != 0) {
                return Result.success("修改密码成功");
            } else {
                return Result.error("修改密码失败");
            }
        } else {
            return Result.error("参数为空");
        }

    }


}
