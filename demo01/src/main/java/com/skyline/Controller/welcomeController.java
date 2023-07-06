package com.skyline.Controller;

import com.skyline.Request.Result;
import com.skyline.Service.orderService;
import com.skyline.Service.productService;
import com.skyline.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/3 15:39]
 */
@RestController
@RequestMapping("/welcome")
public class welcomeController {

    @Autowired
    userService userService;

    @Autowired
    orderService orderService;

    @Autowired
    productService productService;

    @GetMapping("/data")
    public Result welcomeData() {
        Map<String, Number> welcomeData = new HashMap<>();
        int uNum = userService.userNum();
        int pNum = productService.productNum();
        int oNum = orderService.orderNum();
        double mSum = orderService.totalMoney();
        welcomeData.put("uNum", uNum);
        welcomeData.put("pNum", pNum);
        welcomeData.put("oNum", oNum);
        welcomeData.put("mSum", mSum);
        if (welcomeData.isEmpty()) {
            return Result.error();
        } else {
            return Result.success(welcomeData);
        }
    }

}
