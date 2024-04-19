package com.esun.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esun.blog.mapper.PostsMapper;
import com.esun.blog.model.po.Comment;
import com.esun.blog.model.po.Post;
import com.esun.blog.utilities.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 新增發文 newPost(@RequestBody Post post)
 * 列出該文章 getPostById(@PathVariable int postId)
 * 列出所有文章 listAllPostsbyId(int userId)
 * 編輯文章 editPost(@RequestBody Post post)
 * 刪除文章deletePost(@PathVariable int postId)
 */
@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

    @Autowired
    PostsMapper postsMapper;

    @PostMapping("/newPost")
    public Result newPost(@RequestBody Post post) {
        int success = postsMapper.insert(post);
        return success > 0 ? Result.ok() : Result.failure();
    }

    @GetMapping("/{postId}")
    public Result getPostById(@PathVariable int postId) {
        Post post = postsMapper.selectById(postId);
        return post != null ? Result.ok().data("post", post) : Result.failure();
    }

    @PutMapping("/{postId}/edit")
    public Result editPost(@RequestBody Post post) {
        // TODO: check
        int success = postsMapper.updateById(post);
        return success > 0 ? Result.ok() : Result.failure();
    }

    @DeleteMapping("/{postId}/delete")
    public Result deletePost(@PathVariable int postId) {
        int success = postsMapper.deleteById(postId);
        return success > 0 ? Result.ok() : Result.failure();
    }

    @GetMapping("/getAllPosts")
    public Result getAllPostsbyId() {
        List<Post> posts = postsMapper.selectList(null);
        return !posts.isEmpty() ? Result.ok().data("posts", posts) : Result.failure();
    }

}
