// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.gzy.hrms_springboot.controller.dto;

import lombok.Generated;

public class DoctorDto {
    private String name;
    private String password;
//    private String department;
//    private String position;
//    private String phone;

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setPassword(final String password) {
        this.password = password;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DoctorDto)) {
            return false;
        } else {
            DoctorDto other = (DoctorDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$password = this.getPassword();
                Object other$password = other.getPassword();
                if (this$password == null) {
                    if (other$password != null) {
                        return false;
                    }
                } else if (!this$password.equals(other$password)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof DoctorDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getName();
        // 修改17：修改 toString 方法，对应 DoctorDto 字段
        return "DoctorDto(name=" + var10000 + ", password=" + this.getPassword() + ")";
    }
}