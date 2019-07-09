package com.rambo.demo.base.exceptionhandler;

import com.rambo.demo.base.exceptionhandler.exceptions.CommonException;
import com.rambo.demo.base.response.BaseErrorEnum;
import com.rambo.demo.base.response.BaseResult;
import com.rambo.demo.base.response.BaseResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 全局异常拦截处理器
 * User: za-panyong
 * Date: 2019/7/3
 * Time: 17:49
 */
//控制器增强
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    /**
     * 对Exception的异常进行处理
     *
     * @param e
     * @return
     */
    // 该注解定义异常处理器，指定具体的异常类
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult exceptionHandler(Exception e) {
        log.error("全局异常处理器-->", e);
        return BaseResultUtils.error(BaseErrorEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public BaseResult paramValidExceptionHandler(BindException e) {
        log.error("参数校验异常处理器-->", e);
        StringBuffer sb = new StringBuffer();
        List<ObjectError> errorList = e.getAllErrors();
        if (CollectionUtils.isEmpty(errorList)) {
            return BaseResultUtils.error(BaseErrorEnum.PARAMS_ERROR);
        }
        errorList.forEach(objectError -> {
            sb.append(objectError.getDefaultMessage()).append(";");
        });
        return BaseResultUtils.error(BaseErrorEnum.PARAMS_ERROR, sb.substring(0, sb.length()-1));
    }

    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public BaseResult commonException(CommonException e) {
        log.error("通用异常处理器-->", e);
        return BaseResultUtils.error(BaseErrorEnum.COMMON_ERROR);
    }
}
