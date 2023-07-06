package com.skyline.Controller;

import com.github.pagehelper.PageInfo;
import com.skyline.Entity.Product;
import com.skyline.Request.Result;
import com.skyline.Request.productReceive;
import com.skyline.Request.productResult;
import com.skyline.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("/product")
public class productController {


    /**
     * 商品业务层接口
     */
    @Autowired
    private productService productService;


    @RequestMapping("/selectbycid")
    public Result selectProductByCid(Integer cid) {
        if (cid == null) {
            return Result.error("cid为空");
        } else {
            List<Product> pList = productService.selectByCid(cid);
            if (pList.isEmpty()) {
                return Result.error();
            } else {
                return Result.success(pList);
            }
        }
    }

    /**
     * 根据名字(关键字)模糊查找
     * @param pname 商品名字
     * @return
     */
    @RequestMapping("/selectbypname")
    public Result selectBypName(String pname) {
        List<Product> pList = productService.selectProductBypName(pname);
        if (pList != null) {
            return Result.success(pList);
        } else {
            return Result.error();
        }
    }

    /**
     * 返回product表所有记录
     * @return
     */
    @RequestMapping("/list")
    public Result resultAllProducts() {
        List<Product> pList = productService.selectAllProducts();
        int lNum = pList.size();
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("goodsList", pList);
        pMap.put("lNum", lNum);
        System.out.println(pMap);
        if (pList != null) {
            return Result.success(pMap);
        } else {
            return Result.error();
        }
    }

    @RequestMapping("/map")
    public Result productMap() {
        Map<String, Object> pMap = productService.AllProductInfo();
        //        System.out.println(pMap);
        return Result.success(pMap);
    }


    /**
     * 批量（单个）删除商品
     * @param pMap
     * @return
     */
    @RequestMapping("/deletes")
    public Result batchDeleteProducts(@RequestBody Map<String, List<Integer>> pMap) {
        List<Integer> pidList = pMap.get("pids");
        System.out.println(pidList);
        if (pidList.isEmpty()) {
            return Result.error("参数为空");
        } else {
            int flag = productService.deleteProductsByPids(pidList);
            if (flag != 0) {
                return Result.success("删除成功");
            } else {
                return Result.error("删除失败");
            }
        }
        //        return null;
    }

    @GetMapping("/del")
    public Result delByPid(Integer pid) {
        if (pid != null) {
            int flag = productService.delByPid(pid);
            if (flag != 0) {
                return Result.success("删除成功");
            } else {
                return Result.error("删除失败");
            }
        } else {
            return Result.error("参数为空");
        }
    }

    /**
     * 分页显示
     * @param pageNum  当前页
     * @param pageSize 当前页展示数量
     * @return 当前页记录
     */
    @RequestMapping("/pagingshow")
    public Result pagingPage(Integer pageNum, Integer pageSize) {
        PageInfo<Product> pPageInfo = productService.pagingShow(pageNum, pageSize);
        if (pPageInfo != null) {
            return Result.success(pPageInfo);
        } else {
            return Result.error("查找失败");
        }
    }

    @RequestMapping("/nameid")

    public Result productMapBypronameId(String pname, Integer pid) {
        System.out.println(pid);
        System.out.println(pname);
        Map<String, Object> pMap = productService.selectProductByNamePid(pname, pid);
        return Result.success(pMap);
    }

    @RequestMapping("/add")
    public Result addProduct(@RequestBody productReceive pReceive) {
        int flag = productService.addProduct(pReceive);
        if (flag != 0) {
            return Result.success("插入成功");
        } else {
            return Result.error("插入失败");
        }
    }

    @RequestMapping("/selectsingle")
    public Result selectSingleProduct(Integer pid) {
        productResult pResult = productService.selectSingleProduct(pid);
        if (pResult != null) {
            return Result.success(pResult);
        } else {
            return Result.error();
        }
    }

    @RequestMapping("/update")
    public Result updateProduct(@RequestBody productReceive pReceive) {
        int flag = productService.updateProductByPid(pReceive);
        if (flag != 0) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }
    }

    @RequestMapping("/productinfo")
    public Result information() {

        List<Product> products = productService.getGoodsinfo();
        if (products.isEmpty()) {

            return Result.error("获取商品信息失败!!");
        } else {

            return Result.success(products);
        }

    }

    @RequestMapping("/productclassify")
    public Result getGoodsByClass(Integer cid) {

        List<Product> products = productService.getGoodsByClassify(cid);
        if (products.isEmpty()) {

            return Result.error("获取商品信息失败!!");
        } else {

            return Result.success(products);
        }


    }

    @RequestMapping("/productsearch")
    public Result searchGoods(String userput) {

        List<Product> goods = productService.searchGoods(userput);
        if (goods.isEmpty()) {

            return Result.error("商品搜索失败！！");
        } else {

            return Result.success(goods);
        }
    }

    @RequestMapping("/productdetail")
    public Result searchDetail(Integer pid) {

        Product product = productService.getGoodsBypid(pid);
        if (product == null) {

            return Result.error("访问详情失败！！");
        } else {

            return Result.success(product);
        }
    }

}
