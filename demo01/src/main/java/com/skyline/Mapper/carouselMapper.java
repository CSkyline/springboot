package com.skyline.Mapper;

import com.skyline.Entity.Carousel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface carouselMapper {

    /**
     * 通过id查询轮播图
     * @param id
     * @return 根据id查询轮播图
     */
    @Select("SELECT * FROM sc_carousel WHERE id = #{id}")
    List<Carousel> selectById(@Param("id") Integer id);


    /**
     * 返回carousel表所有记录
     * @return
     */
    @Select("SELECT * FROM sc_carousel")
    List<Carousel> selectAll();


    /**
     * 向carousel表插入记录
     * @param carousel
     * @return
     */
    @Insert("INSERT INTO sc_carousel (id,name,url) VALUES (#{id},#{name},#{url})")
    Carousel addCarousel(Carousel carousel);


    /**
     * 通过轮播图id删除carousel表的记录
     * @param id
     * @return
     */
    @Delete("DELETE FROM sc_carousel WHERE id = #{id}}")
    int delCarouselByid(@Param("id") Integer id);


    /**
     * 批量删除carousel记录
     * @param idList
     * @return
     */
    int delCarouselByIds(List<Integer> idList);

    /**
     * 动态删除carousel表记录
     * @param carousel
     * @return
     */
    int updateCarousel(Carousel carousel);
}
