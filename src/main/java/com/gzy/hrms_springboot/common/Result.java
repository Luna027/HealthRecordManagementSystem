//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzy.hrms_springboot.common;
import lombok.Generated;

public class Result {
    private String code;
    private String msg;
    private Object data;


    public static Result success() {
        return new Result("200", "", (Object)null);
    }

    public static Result success(Object data) {
        return new Result("200", "", data);
    }

    public static Result error(String code, String msg) {
        return new Result(code, msg, (Object)null);
    }

    public static Result error() {
        return new Result("500", "系统错误", (Object)null);
    }

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    public String getMsg() {
        return this.msg;
    }

    @Generated
    public Object getData() {
        return this.data;
    }

    @Generated
    public void setCode(final String code) {
        this.code = code;
    }

    @Generated
    public void setMsg(final String msg) {
        this.msg = msg;
    }

    @Generated
    public void setData(final Object data) {
        this.data = data;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getCode();
        return "Result(code=" + var10000 + ", msg=" + this.getMsg() + ", data=" + String.valueOf(this.getData()) + ")";
    }

    @Generated
    public Result(final String code, final String msg, final Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Generated
    public Result() {
    }
}
