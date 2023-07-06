package com.skyline.Service.impl;

import com.skyline.Entity.Receinfo;
import com.skyline.Mapper.receinfoMapper;
import com.skyline.Service.receinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/7/5 16:07]
 */
@Service
public class receinfoServiceImpl implements receinfoService {


    @Autowired
    receinfoMapper receinfoMapper;

    @Override
    public Receinfo selectByRid(Integer rid) {
        Receinfo receinfo = receinfoMapper.selectByid(rid);
        return receinfo;
    }
}
