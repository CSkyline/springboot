package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classify {

    private Integer cid;
    private Integer fcid;
    private String cname;
    private String cicon;
}
