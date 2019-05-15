package com.rambo.demo.component.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * User: za-panyong
 * Date: 2019/5/15
 * Time: 17:28
 */
@Slf4j
/**
 * Servlet3.0提供的特性，用来标识一个实现了Filter接口的类，配合启动类上的@ServletComponentScan注解启动时会自动扫描注册
 * 关于Filter的执行顺序问题，有两种方法可以解决
 * 1. 通过Filter类名的字母表顺序，AuthFilter在CustomFilter前面(默认)
 * 2. 通过在启动类中设置FilterRegistrationBean指定Filter的顺序
 */
@WebFilter(filterName = "customFilter", urlPatterns = {"/*"})
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("CustomFilter 开始执行");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("CustomFilter 执行完毕");
    }

    @Override
    public void destroy() {
        log.info("CustomFilter 销毁");
    }
}
