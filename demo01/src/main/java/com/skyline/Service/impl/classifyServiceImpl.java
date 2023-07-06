package com.skyline.Service.impl;

import com.skyline.Entity.Classify;
import com.skyline.Mapper.classifyMapper;
import com.skyline.Service.classifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public int addClassify(Classify classify) {
        try {
            int flag = classifyMapper.insertClassify(classify);
            if (flag != 0) {
                return 1;

            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int delClassify(Integer cid) {
        try {
            int flag = classifyMapper.delClassifyByCid(cid);
            if (flag != 0) {
                return 1;

            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int updateClassify(Classify classify) {
        try {
            int flag = classifyMapper.updateClassifyByCid(classify);
            if (flag != 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public List<Classify> selectClassifyById(Integer cid) {
        try {
            List<Classify> cList = classifyMapper.findClassifyByCid(cid);
            if (cList != null) {
                return cList;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<Classify> selectClassify() {
        try {
            List<Classify> cList = classifyMapper.selectAll();
            if (cList != null) {
                return cList;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int delClassifyByIDs(List<Integer> cids) {
        try {
            int flag = classifyMapper.deleteClassifyByCids(cids);
            return flag;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }


    /**
     * 将classify表所有记录包装后返回
     * @return
     */
    //    @Override
    //    public List<Classify> classifyShow() {
    //        try {
    //            List<Classify> fcList = classifyMapper.findFirstLevelClassify();
    //            if (fcList.isEmpty() == false) {
    //                List<ClassifyResult> cResultList = new ArrayList<ClassifyResult>();
    //                ClassifyResult tempCR;
    //                for (Classify cy : fcList) {
    //                    Integer cid = cy.getCid();
    //                    String cname = cy.getCname();
    //                    List<Classify> tempClassiyList = classifyMapper.findSubClassifyByFCid(cid);
    //                    tempCR = new ClassifyResult(cid, cname);
    //                    cResultList.add(tempCR);
    //                }
    //                return cResultList;
    //            } else {
    //                System.out.println("未找到分类记录");
    //                return null;
    //            }
    //        } catch (Exception e) {
    //            System.out.println(e);
    //            return null;
    //        }
    //    }

    /**
     * 添加分类并返回添加成功后结果
     * @param classify
     * @return
     */
    //    @Override
    //    public List<Classify> addClassify(Classify classify) {
    //        try {
    //            int flag = classifyMapper.insertClassify(classify);
    //            if (flag != 0) {
    //                List<Classify> classifyList = classifyShow();
    //                return classifyList;
    //            } else {
    //                return null;
    //            }
    //        } catch (Exception e) {
    //            System.out.println(e);
    //            return null;
    //        }
    //    }

    /**
     * 删除分类 若有子分类会一并删除
     * @param cid
     * @return
     */
    //    @Override
    //    public List<Classify> delClassify(Integer cid) {
    //        try {
    //            List<Integer> cidList = classifyMapper.selectCidByFcid(cid);
    //            System.out.println(cidList);
    //            if (cidList.isEmpty() == false) {
    //                int flag = classifyMapper.deleteClassifyByCids(cidList);
    //                if (flag == 0) {
    //                    return null;
    //                }
    //            }
    //            classifyMapper.delClassifyByCid(cid);
    //            List<ClassifyResult> classifyResultsListUtil = classifyShow();
    //            return classifyResultsListUtil;
    //        } catch (Exception e) {
    //            System.out.println(e);
    //            return null;
    //        }
    //    }

    //    @Override
    //    public List<ClassifyResult> updateClassify(Classify classify) {
    //        try {
    //            int flag = classifyMapper.updateClassifyByCid(classify);
    //            if (flag != 0) {
    //                List<ClassifyResult> cRList = classifyShow();
    //                return cRList;
    //            } else {
    //                return null;
    //            }
    //        } catch (Exception e) {
    //            System.out.println(e);
    //            return null;
    //        }
    //    }


}
