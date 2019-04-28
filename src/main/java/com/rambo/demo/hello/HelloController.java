package com.rambo.demo.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 相当于 @RequestMapping(value = "hello", method = RequestMethod.GET)
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String hello(){
        return "Hello SpringBoot!";
    }
}
