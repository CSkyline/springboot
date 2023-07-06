package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/5 15:41]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receinfo {
    private Integer rid;
    private Integer uid;
    private String recname;
    private String address;
    private String tel;
}
