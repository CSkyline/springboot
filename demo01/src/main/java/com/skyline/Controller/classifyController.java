package com.skyline.Controller;

import com.skyline.Common.Result;
import com.skyline.Entity.Classify;
import com.skyline.Service.classifyService;
import com.skyline.Util.ClassifyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * desc:分类控制层
 *
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/6/27 9:11]
 */
@RestController
@RequestMapping("/classify")
public class classifyController {

    @Autowired
    classifyService classifyService;

    /**
     * 添加分类
     *
     * @param classify
     * @return
     */
    @PostMapping("/addclassify")
    public Result addClassify(@RequestBody Classify classify) {
        if (classify != null) {
            List<ClassifyResult> cRList = classifyService.addClassify(classify);
            return new Result().success(cRList);
        } else {
            return new Result().error("参数为空！");
        }
    }

    /**
     * 删除分类（若有子分类会一并删除）
     *
     * @param cid
     * @return
     */
    @GetMapping("/delclassify")
    public Result delClassify(Integer cid) {

        if (cid == null) {
            return new Result().error("参数为空");
        } else {
            List<ClassifyResult> cRList = classifyService.delClassify(cid);
            if (cRList != null) {
                return new Result().success(cRList);
            } else {
                return new Result().error("删除失败");
            }
        }
    }

    /**
     * 查询classify表所有记录
     *
     * @return
     */
    @GetMapping("/classifyshow")
    public Result classifyShow() {
        List<ClassifyResult> cRList = classifyService.classifyShow();
        if (cRList.isEmpty() == false) {
            return new Result().success(cRList);
        } else {
            return new Result().error();
        }
    }

    @PostMapping("/updateclassify")
    public Result updateClassify(@RequestBody Classify classify) {
        System.out.println(classify);
        if (classify.getCid() == null) {
            return new Result().error("参数错误");
        } else {
            List<ClassifyResult> cRList = classifyService.updateClassify(classify);
            if (cRList.isEmpty() == false) {
                return new Result().success(cRList);
            } else {
                return new Result().error();
            }
        }
    }

}