package com.esun.blog.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

import lombok.Data;

@Data
@TableName(value = "Posts", autoResultMap = true)
public class Post {

    @TableId(type = IdType.AUTO)
    Integer postId;

    Integer userId;

    String content;

    String image;

    LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", createAt=" + createdAt.toString() +
                '}';
    }
}
