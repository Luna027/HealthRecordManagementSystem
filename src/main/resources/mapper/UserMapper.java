package com.gzy.hrms_springboot.mapper;

import com.gzy.hrms_springboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_user")
    List<User> findAll();

    @Insert("INSERT INTO sys_user(username,password,nickname,email,phone,address) VALUES(#{username},#{password}," +
            "#{nickname},#{email},#{phone},#{address})") //通过#{}使插入数据是动态的
    int insert(User user);

    int update(User user);
}
