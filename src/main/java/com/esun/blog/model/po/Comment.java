package com.esun.blog.model.po;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "Comments", autoResultMap = true)
public class Comment {

    @TableId(type = IdType.AUTO)
    private int commentId;

    private int userId;

    private int postId;

    private String content;

    private LocalDateTime createAt;

    @Override
    public String toString() {
        return "Comment [commentID=" + commentId + ", userID=" + userId + ", postID=" + postId + ", content=" + content
                + ", createAt=" + createAt + "]";
    }
}
