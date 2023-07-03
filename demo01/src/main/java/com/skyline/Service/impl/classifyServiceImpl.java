package com.skyline.Service.impl;

import com.skyline.Entity.Classify;
import com.skyline.Mapper.classifyMapper;
import com.skyline.Service.classifyService;
import com.skyline.Util.ClassifyResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/6/27 9:03]
 */
@Service
public class classifyServiceImpl implements classifyService {


    /**
     * 分类持久层接口
     */
    @Autowired
    classifyMapper classifyMapper;


    /**
     * 将classify表所有记录包装后返回
     * @return
     */
    @Override
    public List<ClassifyResultUtil> classifyShow() {
        try {
            List<Classify> fcList = classifyMapper.findFirstLevelClassify();
            if (fcList.isEmpty() == false) {
                List<ClassifyResultUtil> cResultList = new ArrayList<ClassifyResultUtil>();
                ClassifyResultUtil tempCR;
                for (Classify cy : fcList) {
                    Integer cid = cy.getCid();
                    String cname = cy.getCname();
                    String cicon = cy.getCicon();
                    List<Classify> tempClassiyList = classifyMapper.findSubClassifyByFCid(cid);
                    tempCR = new ClassifyResultUtil(cid, cname, cicon, tempClassiyList);
                    cResultList.add(tempCR);
                }
                return cResultList;
            } else {
                System.out.println("未找到分类记录");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * 添加分类并返回添加成功后结果
     * @param classify
     * @return
     */
    @Override
    public List<ClassifyResultUtil> addClassify(Classify classify) {
        try {
            int flag = classifyMapper.insertClassify(classify);
            if (flag != 0) {
                List<ClassifyResultUtil> classifyResultsListUtil = classifyShow();
                return classifyResultsListUtil;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * 删除分类 若有子分类会一并删除
     * @param cid
     * @return
     */
    @Override
    public List<ClassifyResultUtil> delClassify(Integer cid) {
        try {
            List<Integer> cidList = classifyMapper.selectCidByFcid(cid);
            System.out.println(cidList);
            if (cidList.isEmpty() == false) {
                int flag = classifyMapper.deleteClassifyByCids(cidList);
                if (flag == 0) {
                    return null;
                }
            }
            classifyMapper.delClassifyByCid(cid);
            List<ClassifyResultUtil> classifyResultsListUtil = classifyShow();
            return classifyResultsListUtil;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<ClassifyResultUtil> updateClassify(Classify classify) {
        try {
            int flag = classifyMapper.updateClassifyByCid(classify);
            if (flag != 0) {
                List<ClassifyResultUtil> cRList = classifyShow();
                return cRList;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


}
