package com.gzy.hrms_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzy.hrms_springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("SELECT * FROM sys_user")
//    List<User> findAll();
//
//    @Insert("INSERT INTO sys_user(username,password,nickname,email,phone,address) VALUES(#{username},#{password}," +
//            "#{nickname},#{email},#{phone},#{address})") //通过#{}使插入数据是动态的
//    int insert(User user);
//
//    int update(User user);
//
//    @Delete("delete from sys_user where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from sys_user where username like #{username} limit #{pageNum}, #{pageSize}")
//    List<User> selectPage(Integer pageNum, Integer pageSize, String username);
//
//    @Select("select count(*) from sys_user where username like concat('%',#{username},'%') ")
//    Integer selectTotal(String username);
}
