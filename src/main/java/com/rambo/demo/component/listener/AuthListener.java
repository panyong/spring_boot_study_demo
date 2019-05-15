package com.rambo.demo.component.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * User: za-panyong
 * Date: 2019/5/15
 * Time: 18:28
 */
@Slf4j
/**
 * Servlet的各个属性的事件监听器，如Context、Request、Session的初始化、销毁事件
 */
@WebListener
public class AuthListener implements ServletRequestListener , ServletContextListener, HttpSessionListener{
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("AuthListener-->请求初始化");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("AuthListener-->请求销毁");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("AuthListener-->上下文初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("AuthListener-->上下文销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("AuthListener-->会话创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("AuthListener-->会话销毁");
    }
}
