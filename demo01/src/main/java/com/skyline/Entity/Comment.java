package com.skyline.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer id;
    private Integer uid;
    private Integer pid;
    private String comment;
    private String addtime;
}
