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
    int postId;

    int userId;

    String content;

    String image;

    LocalDateTime createAt;

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", createAt=" + createAt.toString() +
                '}';
    }
}
