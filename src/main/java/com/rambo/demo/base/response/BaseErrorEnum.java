package com.rambo.demo.base.response;

/**
 * User: za-panyong
 * Date: 2019/7/3
 * Time: 17:56
 */
public enum  BaseErrorEnum {
    SYSTEM_ERROR(20500,"系统错误"),
    COMMON_ERROR(20501,"通用错误"),
    PARAMS_ERROR(20502,"参数错误"),
    ;














    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    BaseErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
