package com.skyline.Service;

import com.github.pagehelper.PageInfo;
import com.skyline.Entity.Product;
import com.skyline.Request.productReceive;
import com.skyline.Request.productResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public interface productService {

    List<Product> selectByCid(Integer cid);

    /*
     * */
    List<Product> selectProductBypName(String pName);

    /*
     *
     * */
    List<Product> selectAllProducts();

    /*
     *
     * */
    int addProduct(productReceive pReceive);


    /*
     *
     * */
    int updateProductByPid(productReceive pReceive);

    /*
     *
     * */
    int deleteProductsByPids(List<Integer> pidList);

    /**
     * 分页显示---业务层接口
     * @param pageNum  当前页
     * @param pageSize 每页显示数量
     * @return
     */
    PageInfo<Product> pagingShow(int pageNum, int pageSize);

    int productNum();

    Map<String, Object> AllProductInfo();


    Map<String, Object> selectProductByNamePid(String proname, Integer pid);

    int delByPid(Integer pid);

    productResult selectSingleProduct(Integer pid);

    List<Product> getGoodsinfo();

    List<Product> getGoodsByClassify(Integer cid);

    List<Product> searchGoods(String userPut);


    Product getGoodsBypid(Integer pid);


}
