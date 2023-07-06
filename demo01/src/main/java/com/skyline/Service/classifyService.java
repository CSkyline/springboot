package com.skyline.Service;

import com.skyline.Entity.Classify;

import java.util.List;

public interface classifyService {


    int addClassify(Classify classify);

    int delClassify(Integer cid);

    int updateClassify(Classify classify);

    List<Classify> selectClassifyById(Integer cid);

    List<Classify> selectClassify();

    int delClassifyByIDs(List<Integer> cids);


}
