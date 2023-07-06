package com.skyline.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skyline.Entity.Product;
import com.skyline.Mapper.SearchMapper;
import com.skyline.Mapper.productMapper;
import com.skyline.Request.productReceive;
import com.skyline.Request.productResult;
import com.skyline.Service.productService;
import com.skyline.Util.productInitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class productServiceImpl implements productService {

    @Autowired
    productMapper productMapper;

    @Autowired
    SearchMapper searchMapper;

    @Override
    public List<Product> selectByCid(Integer cid) {
        try {
            return productMapper.selectBycid(cid);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * 通过商品名称进项模糊查询查询
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
     * 查找所有商品
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
     * 添加单个商品
     * @return
     */
    @Override
    public int addProduct(productReceive pReceive) {
        try {
            Product p = productInitUtil.initProduct(pReceive);
            /*插入商品*/
            productMapper.insertProduct(p);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    /**
     * 通过商品id修改商品信息
     * @return
     */
    @Override
    public int updateProductByPid(productReceive pReceive) {
        try {
            Product p = productInitUtil.initProduct(pReceive);
            productMapper.updateProductByPid(p);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    /**
     * 通过id集合删除商品
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
     * 分页显示
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

    @Override
    public int productNum() {
        int pNum = productMapper.selectProductNum();
        return pNum;
    }

    @Override
    public Map<String, Object> AllProductInfo() {
        List<productResult> pRList = productMapper.selectAllProductInfo();
        int lSize = pRList.size();
        HashMap<String, Object> pMap = new HashMap<>();
        pMap.put("goodsList", pRList);
        pMap.put("lSize", lSize);
        return pMap;
    }

    @Override
    public Map<String, Object> selectProductByNamePid(String proname, Integer pid) {
        List<productResult> pRList = productMapper.selectProductByNamePid(proname, pid);
        int lSize = pRList.size();
        HashMap<String, Object> pMap = new HashMap<>();
        pMap.put("goodsList", pRList);
        pMap.put("lSize", lSize);
        return pMap;
    }

    @Override
    public int delByPid(Integer pid) {
        try {
            int flag = productMapper.deleteByPid(pid);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public productResult selectSingleProduct(Integer pid) {
        try {
            productResult pR = productMapper.selectSingleProduct(pid);
            return pR;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /*deng*/
    @Override
    public List<Product> getGoodsinfo() {
        try {

            List<Product> products = productMapper.productinfo();
            return products;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }

    }

    @Override
    public List<Product> getGoodsByClassify(Integer cid) {
        try {

            List<Product> products = productMapper.selectByClassify(cid);
            return products;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }


    }


    @Override
    public Product getGoodsBypid(Integer pid) {
        try {
            Product product = productMapper.selectBypid(pid);
            return product;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public List<Product> searchGoods(String userPut) {
        try {
            List<Product> goods = searchMapper.selectByKeyword(userPut);
            return goods;
        } catch (Exception e) {

            System.out.println(e);
            return null;

        }

    }
}
