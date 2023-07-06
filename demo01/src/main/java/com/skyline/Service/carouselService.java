package com.skyline.Service;

import com.skyline.Entity.Carousel;

import java.util.List;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/6/28 11:30]
 */
public interface carouselService {

    int updateCarousel(Carousel carousel);

    Carousel selectSingleCarousel(Integer id);

    List<Carousel> selectCarousel();

    int addCarousel(Carousel carousel);

    int delCarousel(Integer id);
}
