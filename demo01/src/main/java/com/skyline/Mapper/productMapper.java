package com.skyline.Mapper;

import com.skyline.Entity.Product;
import com.skyline.Request.productResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface productMapper {


    /*向product表插入数据*/
    @Insert("INSERT INTO sc_product (pid, pname, price, description, imgstr, soldnum, cid, num, addtime) " + "VALUES (#{pid}, #{pname}, #{price}, #{description}, #{imgstr}, #{soldnum}, #{cid}, #{num}, #{addtime})")
    int insertProduct(Product product);

    /*通过当id删除product表的数据*/
    @Delete("DELETE FROM sc_product WHERE pid = #{pid}")
    int deleteByPid(@Param("pid") Integer pid);

    /*根据多个id删除*/
    int deleteProductByIds(List<Integer> pids);

    /*根据id修改*/
    int updateProductByPid(Product product);

    /*查询product表所有数据*/
    @Select("SELECT * FROM sc_product")
    List<Product> selectProductAll();

    /*
     *根据id查询product表单条数据
     * 商品id
     * */
    @Select("SELECT * FROM sc_product WHERE pid = #{pid}")
    Product selectProductByPid(@Param("pid") Integer pid);

    /*
     * 根据分类查询product
     * 参数：分类id
     * */
    @Select("SELECT * FROM sc_product WHERE cid = #{cid}")
    List<Product> selectProductByCid(@Param("cid") Integer cid);


    //    /*
    //     * 通过价格区间查询product
    //     * 参数：minprice：最低价格
    //     *      maxprice：最高价格
    //     * */
    //    @Select("SELECT * FROM sc_product WHERE price BETWEEN #{minPrice} AND #{maxPrice}")
    //    List<Product> selectProductByPrice(@Param("minPrice") BigDecimal minPrice, BigDecimal maxPrice);


    /*
     * 通过商品名称进项模糊查询查询
     * */
    List<Product> selectProductBypName(String pname);


    /*
     * 通过商品名称和上架时间查询
     *
     * */
    List<productResult> selectProductByNamePid(String pname, Integer pid);

    /**
     * 查询product表记录数量
     * @return
     */
    @Select("SELECT COUNT(*) FROM sc_product")
    int selectProductNum();

    //    @Select("SELECT p.*,c.cname FROM sc_product p INNER JOIN sc_classify c ON p.cid = c.cid")
    List<productResult> selectAllProductInfo();

    productResult selectSingleProduct(Integer pid);


    /*deng*/
    @Select("SELECT * FROM sc_product")
    List<Product> productinfo();

    @Select("SELECT * FROM sc_product WHERE cid=#{cid}")
    List<Product> selectByClassify(@Param("cid") Integer cid);

    @Select("SELECT * FROM sc_product WHERE pid=#{pid}")
    Product selectBypid(@Param("pid") Integer pid);

    @Select("SELECT * FROM sc_product WHERE cid = #{cid}")
    List<Product> selectBycid(Integer cid);
}
