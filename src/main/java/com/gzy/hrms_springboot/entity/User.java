package com.gzy.hrms_springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "sys_user")
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    @TableField(value = "avatar_url") //制定数据库的字段名称
    private String avatar;
//    private String avatarUrl; //驼峰自动转下划线
}
