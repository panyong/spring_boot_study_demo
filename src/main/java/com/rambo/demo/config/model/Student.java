package com.rambo.demo.config.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: za-panyong
 * Date: 2019/4/28
 * Time: 16:05
 *
 * @author panyong
 */
@Data
@Component //交由Spring的IoC容器管理
//指定配置文件中的Bean属性的前缀
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private Integer sex;
    private Integer age;
    private List<String> hobbies;
    private Integer num;

    public Student() {
        System.out.println("IoC期间---无参构造器被调用");
    }

    public Student(String name, Integer sex, Integer age, List<String> hobbies, Integer num) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.hobbies = hobbies;
        this.num = num;
        System.out.println("IoC期间---全参构造器被调用");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
