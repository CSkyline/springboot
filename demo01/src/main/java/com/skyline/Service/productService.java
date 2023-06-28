package com.skyline.Service;

import com.github.pagehelper.PageInfo;
import com.skyline.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface productService {

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
    int addProduct(Product product);


    /*
     *
     * */
    int updateProductByPid(Product product);

    /*
     *
     * */
    int deleteProductsByPids(List<Integer> pidList);

    /**
     * 分页显示---业务层接口
     *
     * @param pageNum  当前页
     * @param pageSize 每页显示数量
     * @return
     */
    PageInfo<Product> pagingShow(int pageNum, int pageSize);
}
