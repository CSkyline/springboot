package com.skyline.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skyline.Entity.Product;
import com.skyline.Mapper.productMapper;
import com.skyline.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productServiceImpl implements productService {

    @Autowired
    productMapper productMapper;

    /**
     * 通过商品名称进项模糊查询查询---业务层实现
     *
     * @param pName 商品名字
     * @return
     */
    @Override
    public List<Product> selectProductBypName(String pName) {
        System.out.println(pName);
        try {
            List<Product> pList = productMapper.selectProductBypName(pName);
            return pList;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("fail");
            return null;
        }

    }

    /**
     * 查找所有商品---业务层实现
     *
     * @return 返回商品表所有商品
     */
    @Override
    public List<Product> selectAllProducts() {
        try {
            List<Product> pList = productMapper.selectProductAll();
            return pList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * 添加单个商品---业务层实现
     *
     * @param product 添加的商品信息
     * @return
     */
    @Override
    public int addProduct(Product product) {
        try {
            productMapper.insertProduct(product);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    /**
     * 通过商品id修改商品信息---业务层实现
     *
     * @param product 所修改信息的的包装类product
     * @return
     */
    @Override
    public int updateProductByPid(Product product) {
        try {
            productMapper.updateProductByPid(product);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    /**
     * 通过id集合删除商品---业务层实现4
     *
     * @param pidList 商品id集合
     * @return
     */
    @Override
    public int deleteProductsByPids(List<Integer> pidList) {
        try {
            productMapper.deleteProductByIds(pidList);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    /**
     * 分页显示---业务层实现
     *
     * @param pageNum  当前页
     * @param pageSize 每页显示数量
     * @return
     */
    @Override
    public PageInfo<Product> pagingShow(int pageNum, int pageSize) {
        try {
            //告诉分页组件，需要显示的页码和每页显示的条数
            PageHelper.startPage(pageNum, pageSize);
            List<Product> pList = productMapper.selectProductAll();
            PageInfo<Product> productPageInfo = new PageInfo<>(pList, pageSize);
            return productPageInfo;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
