package com.skyline.Controller;

import com.github.pagehelper.PageInfo;
import com.skyline.Common.Result;
import com.skyline.Entity.Product;
import com.skyline.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 根据名字(关键字)模糊查找--控制层接口
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
     * 返回product表所有记录--控制层接口
     * @return
     */
    @RequestMapping("/allpro")
    public Result resultAllProducts() {
        List<Product> pList = productService.selectAllProducts();
        if (pList != null) {
            return Result.success(pList);
        } else {
            return Result.error();
        }
    }


    /**
     * 添加商品---控制层接口
     * @param product 所添加商品信息
     * @return
     */
    @RequestMapping("/addpro")
    public Result addProduct(@RequestBody Product product) {
        int flag = productService.addProduct(product);
        if (flag != 0) {
            return Result.success("插入成功");
        } else {
            return Result.error("插入失败");
        }
    }

    /**
     * 根据商品id修改商品信息---控制层接口
     * @param product 所需修改商品信息
     * @return
     */
    @RequestMapping("/updatepro")
    public Result updateProduct(@RequestBody Product product) {
        System.out.println(product);
        int flag = productService.updateProductByPid(product);
        if (flag != 0) {
            return Result.success("修改成功!");
        } else {
            return Result.error("修改失败！");
        }
    }

    /**
     * 批量（单个）删除商品---控制层接口
     * @param pidList 商品id集合
     */
    @RequestMapping("/batchdelete")
    public Result batchDeleteProducts(@RequestBody List<Integer> pidList) {
        System.out.println(pidList);
        int flag = productService.deleteProductsByPids(pidList);
        if (flag != 0) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败");
        }
    }

    /**
     * 分页显示--控制层接口
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

}
