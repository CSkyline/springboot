package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCar {
    private Integer id;
    private Integer pid;
    private Integer num;
    private Integer uid;
    private  String  pname;
    private BigDecimal price;
    private String description;
    private String imgstr;
}

