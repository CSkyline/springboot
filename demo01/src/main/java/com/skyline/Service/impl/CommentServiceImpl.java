package com.skyline.Service.impl;

import com.skyline.Entity.Comment;
import com.skyline.Mapper.CommentMapper;
import com.skyline.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public int addComment(Comment comment){
        try{
            commentMapper.insertComment(comment);
            return 1;
        }catch (Exception e){

            System.out.println(e);
            return 0;
        }

    }


    @Override
    public int cutComment(Integer id){
        try{
            commentMapper.deleteComment(id);
            return 1;
        }catch (Exception e){

            System.out.println(e);
            return 0;
        }

    }


    @Override
    public List<Comment> getComment(Integer uid, Integer pid){
        try{
           List<Comment> comments =commentMapper.selectComment(uid,pid);
           return   comments;
        }catch (Exception e){

            System.out.println(e);
            return null;
        }

    }
}
