package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carousel {

    private Integer id; //轮播图id
    private String name;//轮播图名字
    private String url;//轮播图url
    private String aurl;//跳转链接
}
