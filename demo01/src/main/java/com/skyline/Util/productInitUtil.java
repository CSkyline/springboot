package com.skyline.Util;

import com.skyline.Entity.Product;
import com.skyline.Request.productReceive;

import java.io.IOException;

/**
 * desc:初始化product类
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/4 17:08]
 */
public class productInitUtil {
    public static Product initProduct(productReceive pReceive) {
        /*图片动态路径*/
        String path = "";
        /*解码图片并返回url*/
        if (pReceive.getBase64Image() != null) {
            String imgBase64 = pReceive.getBase64Image();
            try {
                path = uploadImgUtil.saveBase64Image(imgBase64);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        /*初始化product类*/
        Product p = new Product();
        p.setImgstr(path);
        p.setPid(pReceive.getPid());
        p.setPname(pReceive.getPname());
        p.setPrice(pReceive.getPrice());
        p.setDescription(pReceive.getDescription());
        p.setNum(pReceive.getNum());
        p.setAddtime(pReceive.getAddtime());
        p.setCid(pReceive.getCid());
        return p;
    }
}
