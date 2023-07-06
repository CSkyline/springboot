package com.skyline.Controller;

import com.skyline.Entity.Carousel;
import com.skyline.Request.Result;
import com.skyline.Service.carouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    carouselService carouselService;

    @RequestMapping("/getcarousel")
    public Result getCarousel() {
        List<Carousel> images = carouselService.selectCarousel();
        if (images.isEmpty()) {
            return Result.error("获取轮播图错误");
        } else {
            return Result.success(images);
        }
    }


}
