package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String uaccount;
    private String upassword;
    private String uname;
    private String uimg;
    private char usex;
    private String uphone;
    private String uaddress;
    private Integer islogin;
}
