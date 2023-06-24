package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private Integer aid;
    private String aaccount;
    private String apassword;
    private String aname;
    private String atel;
    private String aimg;
    private boolean islogin;
}
