package com.skyline.Service;

import com.skyline.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface productService {

    List<Product> selectProductBypName(String pName);
}
