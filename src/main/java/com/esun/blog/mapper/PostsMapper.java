package com.esun.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esun.blog.model.po.Post;

public interface PostsMapper extends BaseMapper<Post> {

    @Select("select * from posts where user_id = #{userId}")
    List<Post> getAllPosts(int userId);

    // @Update("update posts set content = #{content} where post_id = #{postId}")
    // int updateContentByPostId(Post post);
}
