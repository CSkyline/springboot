package com.skyline.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/3 19:05]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class productResult {
    private Integer pid;
    private String pname;
    private BigDecimal price;
    private String imgstr;
    private String description;
    private Integer soldnum;
    private Integer num;
    private String cname;
    private String addtime;
}
