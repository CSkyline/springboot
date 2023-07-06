package com.skyline.Mapper;

import com.skyline.Entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {

    List<Product> selectByKeyword(String userPut);
}
