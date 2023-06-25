package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private Integer aid;
    private String account;
    private String password;
    private String name;
    private String tel;
    private String img;
    private boolean islogin;
}
