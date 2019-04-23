package com.rambo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类，程序入口
 *
 * <br/> @SpringBootApplication：该注解是一个组合注解，指示spring开启自动配置、自动扫描注解等功能，详见该注解
 * <br/> 可用 @SpringBootConfiguration、@EnableAutoConfiguration、@ComponentScan等注解组合代替
 * @author panyong
 */
@SpringBootApplication
public class SpringBootStudyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyDemoApplication.class, args);
		System.out.println("SpringBootStudyDemoApplication run successful");
	}

}
