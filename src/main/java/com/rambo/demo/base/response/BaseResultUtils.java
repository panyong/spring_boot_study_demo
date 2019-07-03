package com.rambo.demo.base.response;

import com.rambo.demo.base.response.BaseResult;

/**
 * User: za-panyong
 * Date: 2019/7/3
 * Time: 17:53
 */
public class BaseResultUtils {
    public static final Integer SUCCESS_CODE= 200;

    public static <T> BaseResult ok(T result){
        BaseResult<T> baseResult = new BaseResult();
        baseResult.setCode(SUCCESS_CODE);
        baseResult.setResult(result);
        return baseResult;
    }

    public static BaseResult ok() {
        return ok(null);
    }

    public static BaseResult error(BaseErrorEnum errorEnum){
        BaseResult baseResult = new BaseResult(errorEnum);
        return baseResult;
    }

    public static BaseResult error(BaseErrorEnum paramsError, String message) {
        BaseResult baseResult = error(paramsError);
        baseResult.setMsg(message);
        return baseResult;
    }
}
