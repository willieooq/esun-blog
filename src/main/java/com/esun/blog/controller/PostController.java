package com.esun.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esun.blog.mapper.PostsMapper;
import com.esun.blog.model.po.Comment;
import com.esun.blog.model.po.Post;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
新增發文 newPost
列出該文章
列出所有發文 listAllPostsbyId(int userId)
編輯或刪除發文
*/
@RestController
public class PostController {

    @Autowired
    PostsMapper postsMapper;

    @PostMapping("/newPost")
    public String newPost(@RequestBody Post post) {
        int success = postsMapper.insert(post);
        return success > 0 ? "發文成功" : "發文失敗";
    }

    @GetMapping("*/posts/{postId}")
    public Post getPostById(@PathVariable int postId) {
        // TODO: 登入判斷
        Post post = postsMapper.getPost(postId);
        return post;
    }

    @GetMapping("/listAllPosts")
    public List<Post> listAllPostsbyId(int userId) {
        List<Post> List = postsMapper.getAllPosts(userId);
        return List;
    }

    @PutMapping("{userId}/posts/{id}/edit")
    public String editPost(@PathVariable String id, @RequestBody String entity) {
        // TODO: process PUT request

        return entity;
    }
}
