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
@TableName(value = "doctor")
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {
    @TableId(type = IdType.AUTO,value = "doctor_id")
    private Integer id;
    private String name;
    @JsonIgnore
    private String password;
    private String gender;
    private Integer age;
    private String department;
    private String position;
    private String phone;
//    private String avatarUrl; //驼峰自动转下划线
}

