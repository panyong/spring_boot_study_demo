package com.rambo.demo.base.response;

import lombok.Data;

/**
 * User: za-panyong
 * Date: 2019/7/3
 * Time: 17:51
 */
@Data
public class BaseResult<T> {
    private Integer code;
    private String msg;
    private T result;

    public BaseResult() {
    }

    public BaseResult(BaseErrorEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.msg = errorEnum.getMsg();
    }
}
