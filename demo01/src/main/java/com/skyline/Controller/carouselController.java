package com.skyline.Controller;

import com.skyline.Entity.Carousel;
import com.skyline.Request.Result;
import com.skyline.Service.carouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/6/28 11:32]
 */
@RestController
@RequestMapping("/carousel")
public class carouselController {

    @Autowired
    carouselService carouselService;


    @RequestMapping("/select")
    public Result selectCarousel() {
        List<Carousel> cList = carouselService.selectCarousel();
        return Result.success(cList);

    }

    @RequestMapping("/selectsingle")
    public Result selectCarouselSingle(Integer id) {
        if (id == null) {
            return Result.error("id为空");
        } else {
            Carousel carousel = carouselService.selectSingleCarousel(id);
            if (carousel == null) {
                return Result.error();
            } else {
                return Result.success(carousel);
            }
        }
    }


    @RequestMapping("/add")
    public Result addCarousel(@RequestBody Carousel carousel) {
        int flag = carouselService.addCarousel(carousel);
        if (flag != 0) {
            return Result.success("插入成功");
        } else {
            return Result.error("插入失败");
        }
    }

    @RequestMapping("/del")
    public Result delCarousel(Integer id) {
        if (id == null) {
            return Result.error("参数为空");
        } else {
            int flag = carouselService.delCarousel(id);
            if (flag == 0) {
                return Result.error("删除失败");
            } else {
                return Result.success("删除成功");
            }
        }
    }

    @RequestMapping("/update")
    public Result updateCarousel(@RequestBody Carousel carousel) {
        int flag = carouselService.updateCarousel(carousel);
        if (flag == 0) {
            return Result.error();
        } else {
            return Result.success();
        }
    }
}
