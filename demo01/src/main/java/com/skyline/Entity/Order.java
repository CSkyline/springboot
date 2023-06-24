package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer oid;
    private String paysn;
    private Integer uid;
    private Integer pid;
    private float price;
    private String addTime;
    private Integer status;
    private String receiver;
    private String tel;
    private String address;
    private Integer pNum;
    private String postage;
    private Integer service;
}
