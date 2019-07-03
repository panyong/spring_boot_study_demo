package com.rambo.demo.hello;

import com.rambo.demo.base.exceptionhandler.exceptions.CommonException;
import com.rambo.demo.base.response.BaseResult;
import com.rambo.demo.base.response.BaseResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * User: za-panyong
 * Date: 2019/4/26
 * Time: 15:42
 * @author panyong
 */
@RestController//该注解相当于@Controller和@ResponseBody的组合,提供Restful接口，返回对象或字符串，直接由Spring转为Json返回给请求方，而不是View
@RequestMapping(value = "hello")//该注解使用在类上，表示该类下的所有方法继承其value作为请求前缀，method则覆盖
@Slf4j
public class HelloController {


    @Value("${encode.test}")
    private String value;

    /**
     * 相当于 @RequestMapping(value = "hello", method = RequestMethod.GET)
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public BaseResult<String> hello() throws Exception {
        Random random = new Random();
        int randomVal = random.nextInt(2);

        switch (randomVal){
            case 0:
                throw new Exception("抛出Exception");
//                break;
            case 1:
                throw new CommonException("抛出CommonException");
//                break;
        }

        return BaseResultUtils.ok("Hello SpringBoot!");

    }
}
