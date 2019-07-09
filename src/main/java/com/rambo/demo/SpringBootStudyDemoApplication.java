package com.rambo.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * 主启动类，程序入口
 *
 * <br/> @SpringBootApplication：该注解是一个组合注解，指示spring开启自动配置、自动扫描注解等功能，详见该注解
 * <br/> 可用 @SpringBootConfiguration、@EnableAutoConfiguration、@ComponentScan等注解组合代替
 * @author panyong
 */
@SpringBootApplication
//@EnableConfigurationProperties(value = {Student.class})//该注解声明了使用配置作为属性值的Bean，且将Bean纳入IoC容器管理；如果在POJO上声明了@Component则不需要该注解
//指定导入的非默认配置文件，可以设置字符编码
//@PropertySource(value = {"classpath:config-test.properties"}, encoding = "UTF-8")
@ServletComponentScan//指示启动时进行Servlet的bean扫描注册
@MapperScan("com.rambo.demo.server.mapper")
public class SpringBootStudyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyDemoApplication.class, args);
		System.out.println("============SpringBootStudyDemoApplication run successful============");
	}


	/*@Bean
	//多个Filter，则注册多个FilterRegistrationBean，在每个对象里设置Filter、name和order
	public FilterRegistrationBean customFilterBean(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(customFilter());
		registrationBean.setName("customFilter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(10);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean authFilterBean(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(authFilter());
		registrationBean.setName("authFilter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(20);
		return registrationBean;
	}*/

	/**
	 * 这种初始化Bean的方式和@WebFilter类似，只不过将由Spring初始化的工作变成了程序员手动初始化，初始化后都是交给Spring的容器进行管理
	 * 这时候可以将Filter类上的@WebFilter和启动类上的@ServletComponentScan去掉
	 * @return
	 */
	/*@Bean
	public CustomFilter customFilter(){
		return new CustomFilter();
	}
	@Bean
	public AuthFilter authFilter(){
		return new AuthFilter();
	}*/

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
