package com.skyline.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

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
public class OrderResultUtil {
    private Integer oid;
    private Integer uid;
    private Integer pid;
    private Integer rid;
    private BigDecimal price;
    private String addtime;
    private Integer status;
    private Integer pnum;
    private String postage;
    private String account;
    private String phone;
    private String proname;
}
