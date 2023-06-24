package com.skyline.Service.impl;
import com.skyline.Mapper.collectMapper;
import com.skyline.Entity.Collect;
import com.skyline.Service.collectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class collectServiceImpl implements collectService {

    @Autowired
    private collectMapper collectMapper;
    @Override
    public Collect searchCollectByUid(Integer uid) {
        try {
            Collect collect = collectMapper.selectByUid(uid);
            return collect;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
}
