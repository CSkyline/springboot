package com.skyline.Service.impl;

import com.skyline.Entity.Collect;
import com.skyline.Mapper.collectMapper;
import com.skyline.Service.collectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class collectServiceImpl implements collectService {

    @Autowired
    private collectMapper collectMapper;
    @Override
    public List<Collect> searchCollectByUid(Integer uid) {
        try {
            List<Collect> collectlist = collectMapper.selectByUid(uid);
            return collectlist;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
}
