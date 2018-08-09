package com.xzcode.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.xzcode.product.app.dao")
@EnableTransactionManagement
public class ZjwlWebApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(ZjwlWebApplication.class, args);
	}
}
