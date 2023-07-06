package com.skyline.Controller;

import com.skyline.Entity.*;
import com.skyline.Request.Result;
import com.skyline.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @Autowired
    private collectService collectService;

    @Autowired
    private orderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/updatepassword")
    public Result updatePassword(@RequestBody User user) {
        Integer flag = userService.updatePssword(user);
        if (flag == -1) {
            return Result.error("参数为空");
        } else if (flag == 0) {
            return Result.error("旧密码错误");
        } else {
            return Result.success("修改成功");
        }
    }


    @RequestMapping("/selectsingle")
    public Result selectByUid(Integer uid) {
        if (uid == null) {
            return Result.error("uid为空");
        } else {
            User user = userService.selectByUid(uid);
            return Result.success(user);
        }
    }

    /**
     * 登录客户端
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/login")
    //        public Result login(@RequestBody User loginuser)
    public Result login(String account, String password) {

        //        System.out.println(loginuser);
        User user = userService.loginUser(account, password);
        if (user == null) {
            return Result.error("user not found!");
        } else {
            return Result.success(user);
        }
    }


    /**
     * 检查账户是否存在
     * @param account 用户账号
     * @return
     */
    @RequestMapping("/verifyact")
    public Result verifyAccount(String account) {
        int flag = userService.checkAccount(account);

        if (flag == 1) {
            return Result.success();
        } else {

            return Result.error("该账号已存在");
        }
    }

    /**
     * 注册账号（用户）
     * @param u
     * @return
     */
    @RequestMapping("/register")
    public Result register(@RequestBody User u) {
        System.out.println(u);
        int flag = userService.registerUser(u);
        if (flag == 1) {
            return Result.success();
        } else {
            return Result.error("该用户已存在");
        }
    }

    @RequestMapping("/update")
    public Result updateUser(@RequestBody User u) {
        int flag = userService.updateUser(u);
        if (flag == 0) {
            return Result.error();
        } else {
            return Result.success();
        }
    }

    /**
     * 注销登录
     * @param uid 用户id
     * @return
     */
    /*后期可能更换成参数为账户*/
    @RequestMapping("/logoff")
    public Result logoff(@RequestParam("id") Integer uid) {

        int flag = userService.updateLogin(uid);
        if (flag == 1) {
            return Result.success();
        } else {
            return Result.error();
        }
    }


    /**
     * 收藏管理
     * @param uid 用户id
     * @return
     */
    @RequestMapping("/collectmgt")
    public Result collectManagement(@RequestParam("id") Integer uid) {

        List<Collect> collectlist = collectService.searchCollectByUid(uid);
        if (collectlist != null) {
            return Result.success(collectlist);
        } else {
            return Result.error("未查询到收藏记录");
        }
    }

    /**
     * 订单管理
     * @param uid 用户id
     * @return 用户信息
     */
    @RequestMapping("/ordermgt")
    public Result orderManagement(@RequestParam("id") Integer uid) {


        List<Order> orderlist = orderService.selectOrderByUid(uid);
        if (orderlist != null) {
            return Result.success(orderlist);
        } else {
            return Result.error("未查询到订单记录");
        }
    }

    @RequestMapping("/select")
    public Result selectUser() {
        List<User> uList = userService.selectUser();
        if (uList.isEmpty()) {
            return Result.error();
        } else {
            return Result.success(uList);
        }
    }

    @RequestMapping("/accountid")
    public Result selectByAccountId(Integer uid, String account) {
        System.out.println(uid);
        System.out.println(account);
        List<User> uList = userService.selectUserByAccountId(uid, account);
        if (uList.isEmpty()) {
            return Result.error();
        } else {
            return Result.success(uList);
        }
    }

    @RequestMapping("/del")
    public Result delUserByUid(Integer uid) {
        if (uid != null) {
            int flag = userService.delByUid(uid);
            if (flag != 0) {
                return Result.success("删除成功");
            } else {
                return Result.error("删除失败");
            }
        } else {
            return Result.error("参数为空");
        }
    }

    @RequestMapping("/deletes")
    public Result delUserByUids(@RequestBody Map<String, List<Integer>> uMap) {
        List<Integer> uidList = uMap.get("uids");
        System.out.println(uidList);
        if (uidList.isEmpty()) {
            return Result.error("参数为空");
        } else {
            int flag = userService.deleteUserByUids(uidList);
            if (flag != 0) {
                return Result.success("删除成功");
            } else {
                return Result.error("删除失败");
            }
        }
    }

    @RequestMapping("/Stcollection")
    public Result collectionSelect(Integer uid) {

        List<Collect> collects = collectService.selectByUid(uid);
        if (collects != null) {
            return Result.success(collects);
        } else {
            return Result.error("未查询到收藏记录");
        }
    }

    @RequestMapping("/Incollection")
    public Result collectionAdd(Collect collect) {

        int flag = collectService.addCollection(collect);
        if (flag == 1) {
            return Result.success();
        } else {
            return Result.error("添加收藏记录失败");
        }
    }

    @RequestMapping("/Offcollection")
    public Result collectionCancle(Collect collect) {

        int flag = collectService.cancleCollection(collect);
        if (flag == 1) {
            return Result.success();
        } else {
            return Result.error("取消收藏失败");
        }
    }

    /*
     * 订单管理
     *
     *
     * */
    @RequestMapping("/searchorder")
    public Result orderSearch(Integer uid) {

        List<Order> orders = orderService.selectByUid(uid);
        if (orders.isEmpty()) {
            return Result.error("未查询到订单记录");
        } else {
            return Result.success(orders);
        }

    }


    /*
     * 地址管理
     *
     *
     */
    @RequestMapping("/addAddress")
    public Result addressAdd(@RequestBody Address address) {

        int flag = addressService.addAddress(address);
        if (flag == 1) {
            return Result.success();
        } else {

            return Result.error("收货信息增添失败！！！");
        }

    }

    @RequestMapping("/deleteAddress")
    public Result addressDelete(Integer rid) {
        System.out.println(rid);
        int flag = addressService.deleteAddress(rid);
        if (flag == 1) {
            return Result.success();
        } else {

            return Result.error("收货信息删除失败！！！");
        }


    }

    @RequestMapping("/getAddress")
    public Result getAddress(Integer uid) {

        System.out.println(uid);
        List<Address> ad = addressService.getAddress(uid);
        if (ad == null) {

            return Result.error("获取收货信息失败！！！");
        } else {

            return Result.success(ad);
        }
    }

    /*评论 */
    @RequestMapping("/addcomment")
    public Result addComment(Comment comment) {

        int flag = commentService.addComment(comment);
        if (flag == 1) {
            return Result.success();

        } else {

            return Result.error("评论失败！！");
        }
    }

    @RequestMapping("/cutcomment")
    public Result cutComment(Integer id) {

        int flag = commentService.cutComment(id);
        if (flag == 1) {
            return Result.success();

        } else {

            return Result.error("评论删除失败！！");
        }
    }

    @RequestMapping("/getcomment")
    public Result getComment(Integer uid, Integer pid) {

        List<Comment> comments = commentService.getComment(uid, pid);
        if (comments.isEmpty()) {
            return Result.error("获取评论失败！！");

        } else {
            return Result.success(comments);

        }
    }

}
