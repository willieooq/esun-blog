package com.esun.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.esun.blog.model.po.User;

public interface UsersMapper extends BaseMapper<User> {

    // @Insert("INSERT INTO users values(#{userId},#{username}, #{email},
    // #{password}, #{coverImage}, #{biography})")
    // public int addUser(User user);

    // @Update("update users set username=#{username}, email=#{email},
    // password=#{password}, cover_image=#{cover_image}, biography=#{biography}
    // where user_id=#{user_id}")
    // int updateUser();

    // @Delete("delete from users where user_id = #{user_id}")
    // int deleteUser();

    // @Select("select * from users where user_id = #{user_id}")
    // public User findById(int user_id);

    // @Select("select * from users")
    // public List<User> getAll();

}
