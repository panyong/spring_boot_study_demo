package com.rambo.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

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
		System.out.println("============SpringBootStudyDemoApplication run successful============");
	}

	//声明一个bean交给spring的IOC管理，注解式Bean代替xml，一般在每个相应的配置类中进行Bean的声明
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

}
