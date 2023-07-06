package com.skyline.Request;

import com.skyline.Entity.Order;
import com.skyline.Entity.Receinfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/6/27 14:47]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResult {
    private Order order;
    private String account;
    private String phone;
    private String pname;
    private Receinfo receinfo;
}
