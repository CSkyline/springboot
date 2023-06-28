package com.skyline.Controller;

import com.skyline.Common.Result;
import com.skyline.Service.orderService;
import com.skyline.Util.OrderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * desc:
 *
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/6/27 15:05]
 */
@RestController
@RequestMapping("/order")
public class orderController {

    @Autowired
    orderService orderService;


    /**
     * @param oid
     * @param addtime
     * @param account
     * @return
     */
    @PostMapping("/searchorder")
    public Result findOrderByOidAddtimeUaccount(@PathParam("oid") Integer oid, @PathParam("addtime") String addtime, @PathParam("account") String account) {
        System.out.println(oid);
        System.out.println(addtime);
        System.out.println(account);
        List<OrderResult> oRList = orderService.findOrderByOidAddTimeAndAccount(oid, addtime, account);
        if (oRList.isEmpty() == false) {
            return new Result().success(oRList);
        } else {
            return new Result().error("未找到订单！");
        }
    }
}
