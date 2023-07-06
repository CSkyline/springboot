package com.skyline.Util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/4 10:52]
 */
public class uploadImgUtil {

    /*存储路径*/
    private static final String BASE_PATH = "D:\\PracticalTraining\\springboot\\demo01\\src\\main\\resources\\static\\img\\";

    /*访问路径*/
    private static final String SERVER_PATH = "http://localhost:8080/img/";


    public static String saveBase64Image(String base64Image) throws IOException {
        //去除前缀
        String[] parts = base64Image.split(",");
        String base64EncodedData = parts[1];

        // 生成唯一的文件名
        String fileName = UUID.randomUUID().toString() + ".png";
        String filePath = BASE_PATH + fileName; // 修改为你的项目实际路径

        // 解码Base64图片数据
        byte[] decodedBytes = Base64.decodeBase64(base64EncodedData);

        // 保存图片文件到本地
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(decodedBytes);
        }

        return SERVER_PATH + fileName;
    }
}



