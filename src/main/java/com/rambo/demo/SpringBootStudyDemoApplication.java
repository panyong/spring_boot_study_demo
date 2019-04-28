package com.rambo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * 主启动类，程序入口
 *
 * <br/> @SpringBootApplication：该注解是一个组合注解，指示spring开启自动配置、自动扫描注解等功能，详见该注解
 * <br/> 可用 @SpringBootConfiguration、@EnableAutoConfiguration、@ComponentScan等注解组合代替
 * @author panyong
 */
@SpringBootApplication
//@EnableConfigurationProperties(value = {Student.class})//该注解声明了使用配置作为属性值的Bean，且将Bean纳入IoC容器管理；如果在POJO上声明了@Component则不需要改注解
//指定导入的非默认配置文件
@PropertySource(value = {"classpath:config-test.properties"}, encoding = "UTF-8")
public class SpringBootStudyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyDemoApplication.class, args);
		System.out.println("============SpringBootStudyDemoApplication run successful============");
	}

	//声明一个bean交给spring的IOC管理，注解式Bean代替xml，一般在每个相应的配置类中进行Bean的声明
	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}*/

}
