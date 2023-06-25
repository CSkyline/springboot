package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer oid;
    private Integer uid;
    private Integer pid;
    private Integer rid;
    private BigDecimal price;
    private String addTime;
    private Integer status;
    private Integer pnum;
    private String postage;
}
