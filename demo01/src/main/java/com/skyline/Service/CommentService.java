package com.skyline.Service;

import com.skyline.Entity.Comment;

import java.util.List;

public interface CommentService {

    int addComment(Comment comment);

    int cutComment(Integer id);

    List<Comment> getComment(Integer uid,Integer pid);
}
