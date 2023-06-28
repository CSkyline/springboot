package com.skyline.Util;

import com.skyline.Entity.Classify;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * desc:
 *
 * @author : skyline
 * @version : [v1.0]
 * @createTime : [2023/6/27 10:21]
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassifyResult {

    private Integer cid;
    private String name;
    private String cicon;
    private List<Classify> childClassifyList;
}
