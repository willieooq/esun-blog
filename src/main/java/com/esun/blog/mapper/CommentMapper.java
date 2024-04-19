package com.esun.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esun.blog.model.po.Comment;

public interface CommentMapper extends BaseMapper<Comment> {

    @Select("select * from comments where post_id = #{postId}")
    public List<Comment> listComments(int postId);
}
