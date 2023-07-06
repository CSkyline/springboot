package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private Integer rid;

    private Integer uid;

    private String recname;

    private String address;

    private String tel;


}
