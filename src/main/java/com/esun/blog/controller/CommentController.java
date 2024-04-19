package com.esun.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esun.blog.mapper.CommentMapper;
import com.esun.blog.model.po.Comment;
import com.esun.blog.utilities.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 新增留言 addComment(@RequestBody String entity)
 * 修改留言 editComment(@RequestBody Comment comment)
 * 刪除留言 deleteComment(@RequestBody Comment comment)
 * 列出留言 listComments(@RequestParam Integer postId)
 */
@RestController
@RequestMapping("/posts/{postId}")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @PostMapping("/addComment")
    public Result addComment(@RequestBody Comment comment) {

        int result = commentMapper.insert(comment);

        return result > 0 ? Result.ok() : Result.failure();
    }

    @PutMapping("/editComment")
    public Result editComment(@RequestBody Comment comment) {
        // TODO: check
        int result = commentMapper.updateById(comment);
        return result > 0 ? Result.ok() : Result.failure();
    }

    @DeleteMapping("/deleteComment")
    public Result deleteComment(@RequestBody Comment comment) {
        // TODO: check
        int result = commentMapper.deleteById(comment);
        return result > 0 ? Result.ok() : Result.failure();
    }

    @GetMapping("/listComments")
    public Result listComments(@RequestParam Integer postId) {
        List<Comment> comments = commentMapper.listComments(postId);
        return !comments.isEmpty() ? Result.ok().data("comments", comments) : Result.failure();
    }

}
