package com.skyline.Service.impl;

import com.skyline.Entity.Carousel;
import com.skyline.Mapper.carouselMapper;
import com.skyline.Service.carouselService;
import com.skyline.Util.carouselInitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 */
@Service
public class carouselServiceImpl implements carouselService {


    @Autowired
    carouselMapper carouselMapper;

    @Override
    public int updateCarousel(Carousel carousel) {
        try {
            return carouselMapper.updatCarousel(carousel);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public Carousel selectSingleCarousel(Integer id) {
        try {
            return carouselMapper.selectCarouselSingle(id);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Carousel> selectCarousel() {
        List<Carousel> cList = carouselMapper.selectAll();
        return cList;
    }

    @Override
    public int addCarousel(Carousel carousel) {
        try {
            Carousel c = carouselInitUtil.initCarousel(carousel);
            //            System.out.println(c.getUrl());
            //            System.out.println(c.getAurl());
            int flag = carouselMapper.addCarousel(c);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }

    @Override
    public int delCarousel(Integer id) {
        try {
            int flag = carouselMapper.delCarouselByid(id);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}
