package com.rambo.demo.lombok;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * User: za-panyong
 * Date: 2019/4/26
 * Time: 18:44
 */
@Data
//@NoArgsConstructor
public class Demo {
    @NotNull(message = "code不能为空")
    String code;
    @Pattern(regexp = "[0-9]", message = "")
    String name;
}
