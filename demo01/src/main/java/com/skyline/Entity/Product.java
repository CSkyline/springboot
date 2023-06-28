package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer pid;
    private String proname;
    private BigDecimal price;
    private String description;
    private String imgstr;
    private Integer soldnum;
    private Integer cid;
    private Integer num;
    private String addtime;
}
