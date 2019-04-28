package com.rambo.demo.config;

import com.rambo.demo.config.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: za-panyong
 * Date: 2019/4/28
 * Time: 16:05
 * @author panyong
 */
@RestController
@RequestMapping(value = "/config")
public class ConfigController {
    @Autowired
    private Student student;

    @RequestMapping(method = RequestMethod.GET)
    public String config(){
        return student.toString();
    }
}
