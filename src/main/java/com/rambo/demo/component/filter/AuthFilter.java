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
 * Time: 17:47
 */
@Slf4j
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("AuthFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("AuthFilter 开始执行");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("AuthFilter 执行完毕");
    }

    @Override
    public void destroy() {
        log.info("AuthFilter 销毁");
    }
}
