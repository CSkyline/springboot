package com.skyline.Controller;

import com.skyline.Common.Result;
import com.skyline.Entity.Collect;
import com.skyline.Entity.Order;
import com.skyline.Entity.User;
import com.skyline.Service.collectService;
import com.skyline.Service.orderService;
import com.skyline.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @Autowired
    private collectService collectService;

    @Autowired
    private orderService orderService;


    /*
     * 登录
     * uaccount:账号
     * upassword:密码
     * code:1:success 0:fail
     * */
    @RequestMapping("/login")
    public Result login(String uaccount, String upassword) {

        User user = userService.selectByAP(uaccount, upassword);

        if (user == null) {
            return new Result().error("user not found!");
        } else {
            return new Result().success(user);
        }
    }


    /*
     *验证账户是否存在
     * 参数：uaccount 账户
     * 状态：1:success 0:fail
     * */
    @RequestMapping("/verifyact")
    public Result verifyAccount(String uaccount) {
        int flag = userService.selectByAccount(uaccount);

        if (flag == 1) {
            return new Result().success();
        } else {

            return new Result().error("该账号已存在");
        }
    }

    /*
     * 用户注册
     *参数：账号：uaccount  密码：upassword
     *
     * */
    @RequestMapping("/register")
    public Result register(String uaccount, String upassword) {

        int flag = userService.insertUser(uaccount, upassword);
        if (flag == 1) {
            return new Result().success();
        } else {
            return new Result().error("该用户已存在");
        }
    }

    /*
     * 用户注销登录
     *参数：uid
     * */
    @RequestMapping("/logoff")
    public Result logoff(Integer uid) {

        int flag = userService.updatelogin(uid);
        if (flag == 1) {
            return new Result().success();
        } else {
            return new Result().error();
        }
    }


    /*
     * 订单管理 order management
     *
     * */
    @RequestMapping("/collectmgt")
    public Result collectManagement(Integer uid) {

        Collect collect = collectService.selectByUid(uid);
        if (collect != null) {
            return new Result().success(collect);
        } else {
            return new Result().error("未查询到收藏记录");
        }
    }

    /*
     * 订单管理
     *
     *
     * */
    @RequestMapping("/ordermgt")
    public Result orderManagement(Integer uid) {


        Order order = orderService.selectByUid(uid);
        if (order != null) {
            return new Result().success(order);
        } else {
            return new Result().error("未查询到订单记录");
        }
    }

}
