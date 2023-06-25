package com.skyline.Service.impl;

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
    @Override
    public List<Product> selectProductBypName(String pName) {
        System.out.println(pName);
        try {
            List<Product> pList = productMapper.selectProductBypName(pName);
            return pList;
        }catch (Exception e){
            System.out.println(e);
            System.out.println("fail");
            return null;
        }

    }
}
