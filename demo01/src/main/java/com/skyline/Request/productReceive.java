package com.skyline.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/4 14:13]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class productReceive {
    private Integer pid;
    private String pname;
    private BigDecimal price;
    private String description;
    private Integer num;
    private Integer cid;
    private String addtime;
    private String base64Image;
}
