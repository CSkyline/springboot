package com.skyline.Mapper;

import com.skyline.Entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("INSERT INTO  sc_comment  VALUES (#{id},#{uid},#{pid},#{comment},NOW())")
    void insertComment(Comment comment);

    @Delete("DELETE FROM sc_comment WHERE id=#{id}")
    void deleteComment(@Param("id") Integer id);

    @Select("SELECT comment FROM sc_comment WHERE uid=#{uid} AND pid=#{pid}")
    List<Comment> selectComment(@Param("uid") Integer uid,@Param("pid") Integer pid);
}
