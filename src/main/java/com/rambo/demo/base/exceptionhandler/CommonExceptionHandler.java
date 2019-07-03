package com.rambo.demo.base.exceptionhandler;

import com.rambo.demo.base.exceptionhandler.exceptions.CommonException;
import com.rambo.demo.base.response.BaseErrorEnum;
import com.rambo.demo.base.response.BaseResult;
import com.rambo.demo.base.response.BaseResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**全局异常拦截处理器
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
     * @param e
     * @return
     */
    // 该注解定义异常处理器，指定具体的异常类
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult exceptionHandler(Exception e){
        log.error("全局异常处理器-->",e);
        return BaseResultUtils.error(BaseErrorEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public BaseResult commonException(CommonException e){
        log.error("通用异常处理器-->",e);
        return BaseResultUtils.error(BaseErrorEnum.COMMON_ERROR);
    }
}
