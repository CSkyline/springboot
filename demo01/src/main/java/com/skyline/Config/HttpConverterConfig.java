package com.skyline.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/4 15:37]
 */
@Configuration
public class HttpConverterConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //其中image表示访问的前缀。"file:F:/img/"是文件真实的存储路径D:\PracticalTraining\data\img
        registry.addResourceHandler("/img/**").addResourceLocations("file:D:/PracticalTraining/springboot/demo01/src/main/resources/static/img/");
    }

}

/*
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:D:/manager/");
    }
}


*
*
*
* */