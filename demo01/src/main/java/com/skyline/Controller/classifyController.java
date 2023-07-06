package com.skyline.Controller;

import com.skyline.Entity.Classify;
import com.skyline.Request.Result;
import com.skyline.Service.classifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * desc:分类控制层
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
     * @param classify
     * @return
     */
    @PostMapping("/add")
    public Result addClassify(@RequestBody Classify classify) {
        if (classify != null) {
            int flag = classifyService.addClassify(classify);
            if (flag != 0) {
                return Result.success("插入成功");
            } else {
                return Result.error("插入失败");
            }

        } else {
            return Result.error("参数为空！");
        }
    }

    /**
     * 删除分类（若有子分类会一并删除）
     * @param cid
     * @return
     */
    @GetMapping("/del")
    public Result delClassify(Integer cid) {

        if (cid == null) {
            return Result.error("参数为空");
        } else {
            int flag = classifyService.delClassify(cid);
            if (flag != 0) {
                return Result.success("删除成功");
            } else {
                return Result.error("删除失败");
            }
        }
    }

    @RequestMapping("/deletes")
    public Result delClassifyByIds(@RequestBody Map<String, List<Integer>> cMap) {
        List<Integer> cidList = cMap.get("cids");
        if (cidList.isEmpty()) {
            return Result.error("参数为空");
        } else {
            int flag = classifyService.delClassifyByIDs(cidList);
            if (flag != 0) {
                return Result.success("删除成功");
            } else {
                return Result.error("删除失败");
            }
        }
    }


    /**
     * 查询classify表所有记录
     * @return
     */
    @GetMapping("/show")
    public Result classifyShow() {
        List<Classify> cList = classifyService.selectClassify();
        if (cList.isEmpty() == false) {
            return Result.success(cList);
        } else {
            return Result.error();
        }
    }

    @PostMapping("/update")
    public Result updateClassify(@RequestBody Classify classify) {
        System.out.println(classify);
        if (classify.getCid() == null) {
            return Result.error("参数错误");
        } else {
            int flag = classifyService.updateClassify(classify);
            if (flag != 0) {
                return Result.success("修改成功");
            } else {
                return Result.error("修改失败");
            }
        }
    }

}
