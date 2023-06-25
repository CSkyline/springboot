package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer pid;
    private String proname;
    private BigDecimal price;
    private String desc;
    private List<String> imgstr;
    private Integer sold;
    private Integer cid;
    private Integer num;
    private String addtime;
}
