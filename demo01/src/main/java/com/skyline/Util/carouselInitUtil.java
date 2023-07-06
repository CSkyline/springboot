package com.skyline.Util;

import com.skyline.Entity.Carousel;

import java.io.IOException;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/5 10:21]
 */
public class carouselInitUtil {

    public static Carousel initCarousel(Carousel carousel) {
        /*图片动态路径*/
        String path = "";
        if (carousel.getUrl() != null) {
            String imgBase64 = carousel.getUrl();
            try {
                path = uploadImgUtil.saveBase64Image(imgBase64);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        carousel.setUrl(path);
        return carousel;
    }

}
