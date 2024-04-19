package com.esun.blog.model.po;

import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import jakarta.persistence.Entity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Entity
@Data
@TableName(value = "Users", autoResultMap = true)
public class User {

    @TableId(type = IdType.AUTO)
    private Integer userId;
    // 名稱
    private String username;
    // email
    private String email;
    // 密碼
    private String password;
    // 圖片
    @TableField("cover_image")
    private String coverImage;
    // 使用者的自我介紹
    private String biography;

    @Override
    public String toString() {
        return "User [user_id=" + userId + ", name=" + username + ", email=" + email + ", password=" + password
                + ", cover_image="
                + coverImage
                + ", biography=" + biography + "]";
    }
    
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<User> query = builder.createQuery(User.class);
Root<User> root = query.from(User.class);
query.select(root).where(builder.equal(root.get("username"), username), builder.equal(root.get("password"), password));
List<User> users = entityManager.createQuery(query).getResultList();
}