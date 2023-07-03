package com.skyline.Service;

import com.skyline.Entity.Classify;
import com.skyline.Util.ClassifyResultUtil;

import java.util.List;

public interface classifyService {


    List<ClassifyResultUtil> classifyShow();

    /**
     * 添加分类
     * @param classify
     * @return 添加后的分类表里的记录
     */
    List<ClassifyResultUtil> addClassify(Classify classify);


    List<ClassifyResultUtil> delClassify(Integer cid);

    List<ClassifyResultUtil> updateClassify(Classify classify);

}
