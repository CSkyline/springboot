package com.skyline.Service;


import com.skyline.Entity.Collect;

import java.util.List;

public interface collectService {

    /*
     * */
    List<Collect> searchCollectByUid(Integer uid);

    /*deng*/
    List<Collect> selectByUid(Integer uid);

    int addCollection(Collect collect);

    int cancleCollection(Collect collec);
}
