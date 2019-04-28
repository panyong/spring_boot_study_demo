package com.rambo.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 测试类
 * JUnit使用SpringRunner这个类运行单元测试
 */
@RunWith(SpringRunner.class)
/**
 * 使用随机端口启动web服务，将随机端口赋值给 参数 local.server.port
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootStudyDemoApplicationTests {

	//相当于 @Value("${local.server.port}")
	@LocalServerPort
	private int port;
	private URL base;

	@Autowired
	private TestRestTemplate testRestTemplate;

/*	@Test
	public void contextLoads() {
		System.out.println("run");
	}*/

	@Before
	public void setUp() throws MalformedURLException {
		this.base = new URL("http://localhost:" + port + "/hello");
	}

	@Test
	public void getHello(){
		ResponseEntity<String> response = testRestTemplate.getForEntity(this.base.toString(), String.class);
		Assert.assertTrue(response.getBody().toString().equals("Hello SpringBoot!"));
	}
}
