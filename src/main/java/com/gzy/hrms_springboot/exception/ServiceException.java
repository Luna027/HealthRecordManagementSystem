package com.gzy.hrms_springboot.exception;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import lombok.Generated;

public class ServiceException extends RuntimeException {
    private String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    @Generated
    public String getCode() {
        return this.code;
    }
}
