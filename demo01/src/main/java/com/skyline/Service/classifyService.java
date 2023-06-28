package com.skyline.Service;

import com.skyline.Entity.Classify;
import com.skyline.Util.ClassifyResult;

import java.util.List;

public interface classifyService {


    List<ClassifyResult> classifyShow();

    /**
     * 添加分类
     *
     * @param classify
     * @return 添加后的分类表里的记录
     */
    List<ClassifyResult> addClassify(Classify classify);


    List<ClassifyResult> delClassify(Integer cid);

    List<ClassifyResult> updateClassify(Classify classify);

}
