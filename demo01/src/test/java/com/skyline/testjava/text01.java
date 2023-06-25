package com.skyline.testjava;

import com.skyline.Entity.Product;
import com.skyline.Service.impl.productServiceImpl;
import com.skyline.Service.productService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class text01 {

    @Test
    public void selectByName(){
        productService productService = new productServiceImpl();
        List<Product> po = productService.selectProductBypName("po");
        System.out.println(po);
    }
}
