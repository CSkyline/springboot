package com.skyline.Util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/1 18:41]
 */
public class uploadImgUtils {

    /*存储路径*/
    private static final String BASE_PATH = "D:\\Programming\\Java\\TomCat9\\webapps\\upload\\img\\";

    /*访问路径*/
    private static final String SERVER_PATH = "http://localhost:8080/upload/img/";

    public static String upload(MultipartFile file) {
        /*获取上传文件名称*/
        String filename = file.getOriginalFilename();

        /*保证图片名字唯一性，生成uuid*/
        String uuid = UUID.randomUUID().toString().replace("_", "");

        /*将uuid和名字拼接*/
        String newFileName = filename + "_" + uuid;

        /*创建文件实例对象*/
        File image = new File(BASE_PATH, newFileName);

        try {
            file.transferTo(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return SERVER_PATH + newFileName;
    }

}
