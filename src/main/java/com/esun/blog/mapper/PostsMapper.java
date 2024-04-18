package com.esun.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esun.blog.model.po.Post;

public interface PostsMapper extends BaseMapper<Post> {

    @Select("select * from posts where user_id = #{userId}")
    List<Post> getAllPosts(int userId);

    @Select("select * from posts where post_id = #{postId}")
    Post getPost(int postId);
}
