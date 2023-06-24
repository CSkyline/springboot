package com.skyline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.skyline.Mapper")
@SpringBootApplication
public class Demo01Application {

    public static void main(String[] args) {

        SpringApplication.run(Demo01Application.class, args);
    }

}
