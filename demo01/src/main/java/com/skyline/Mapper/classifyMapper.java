package com.skyline.Mapper;

import com.skyline.Entity.Classify;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * classify表的Mapper接口--持久层
 */
@Mapper
public interface classifyMapper {

    /**
     * 向分类表classify插入一条记录
     *
     * @param classify classif表对应的实体类
     * @return *
     */
    @Insert("INSERT INTO sc_classify (fcid, cname, cicon) VALUES (#{fcid}, #{cname}, #{cicon});")
    int insertClassify(Classify classify);


    /**
     * 通过分类id删除记录
     *
     * @param cid 分类id
     * @return
     */
    @Delete("DELETE FROM sc_classify WHERE cid = #{cid};")
    int deleteByCid(@Param("cid") Integer cid);


    /**
     * 通过分类id集合删除多条记录
     *
     * @return
     */
    int deleteClassifyByCids(List<Integer> cids);

    @Delete("DELETE FROM sc_classify WHERE cid = #{cid}")
    int delClassifyByCid(@Param("cid") Integer cid);

    /**
     * 通过分类id修改记录
     *
     * @param classify
     * @return
     */
    int updateClassifyByCid(Classify classify);


    /**
     * 查询一级分类，即 fcid 属性为空的分类记录
     *
     * @return
     */
    @Select("SELECT * FROM sc_classify WHERE fcid IS NULL")
    List<Classify> findFirstLevelClassify();

    /**
     * 查询某一级分类下的所有子分类，即 fcid 属性等于指定 cid 的分类记录
     *
     * @param cid
     * @return
     */
    @Select("SELECT * FROM sc_classify WHERE fcid = #{fcid}")
    List<Classify> findSubClassifyByFCid(@Param("fcid") Integer cid);


    @Select("SELECT * FROM sc_classify")
    List<Classify> selectAll();

    @Select("SELECT cid FROM sc_classify WHERE fcid = #{fcid}")
    List<Integer> selectCidByFcid(@Param("fcid") Integer fcid);
}
