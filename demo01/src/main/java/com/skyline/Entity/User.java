package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String account;
    private String password;
    private String username;
    private String userimg;
    private String phone;
    private Integer islogin;
    private String oldpassword;
}
