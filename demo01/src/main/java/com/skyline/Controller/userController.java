package com.skyline.Controller;

import com.skyline.Common.Result;
import com.skyline.Entity.Collect;
import com.skyline.Entity.Order;
import com.skyline.Entity.User;
import com.skyline.Service.collectService;
import com.skyline.Service.orderService;
import com.skyline.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    /*用户业务层接口*/
    @Autowired
    private userService userService;

    /*收藏业务层接口*/
    @Autowired
    private collectService collectService;

    /*订单业务层接口*/
    @Autowired
    private orderService orderService;


    /**
     * 登录客户端
     *
     * @param loginuser
     * @return
     */
    @RequestMapping("/login")
    public Result login(@RequestBody User loginuser) {
        System.out.println(loginuser);
        User user = userService.loginUser(loginuser.getAccount(), loginuser.getPassword());
        if (user == null) {
            return new Result().error("user not found!");
        } else {
            return new Result().success(user);
        }
    }


    /**
     * 检查账户是否存在
     *
     * @param account 用户账号
     * @return
     */
    @RequestMapping("/verifyact")
    public Result verifyAccount(String account) {
        int flag = userService.checkAccount(account);

        if (flag == 1) {
            return new Result().success();
        } else {

            return new Result().error("该账号已存在");
        }
    }

    /**
     * 注册账号（用户）
     *
     * @param account  用户账号
     * @param password 用户密码
     * @return
     */
    @RequestMapping("/register")
    public Result register(String account, String password) {

        int flag = userService.registerUser(account, password);
        if (flag == 1) {
            return new Result().success();
        } else {
            return new Result().error("该用户已存在");
        }
    }

    /**
     * 注销登录
     *
     * @param uid 用户id
     * @return
     */
    /*后期可能更换成参数为账户*/
    @RequestMapping("/logoff")
    public Result logoff(@RequestParam("id") Integer uid) {

        int flag = userService.updateLogin(uid);
        if (flag == 1) {
            return new Result().success();
        } else {
            return new Result().error();
        }
    }


    /**
     * 收藏管理
     *
     * @param uid 用户id
     * @return
     */
    @RequestMapping("/collectmgt")
    public Result collectManagement(@RequestParam("id") Integer uid) {

        List<Collect> collectlist = collectService.searchCollectByUid(uid);
        if (collectlist != null) {
            return new Result().success(collectlist);
        } else {
            return new Result().error("未查询到收藏记录");
        }
    }

    /**
     * 订单管理
     *
     * @param uid 用户id
     * @return 用户信息
     */
    @RequestMapping("/ordermgt")
    public Result orderManagement(@RequestParam("id") Integer uid) {


        List<Order> orderlist = orderService.selectOrderByUid(uid);
        if (orderlist != null) {
            return new Result().success(orderlist);
        } else {
            return new Result().error("未查询到订单记录");
        }
    }

}
