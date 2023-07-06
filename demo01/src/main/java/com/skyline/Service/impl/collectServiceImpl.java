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
            List<Collect> collectlist = collectMapper.AselectByUid(uid);
            return collectlist;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public List<Collect> selectByUid(Integer uid) {
        try {
            List<Collect> list;
            list = collectMapper.selectByUid(uid);
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public int addCollection(Collect collect) {
        try {
            collectMapper.insertCollection(collect.getId(), collect.getUid(), collect.getPid());
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }

    @Override
    public int cancleCollection(Collect collect) {
        try {
            collectMapper.deleteCollection(collect.getId());
            return 1;
        } catch (Exception e) {

            System.out.println(e);
            return 0;
        }
    }
}
