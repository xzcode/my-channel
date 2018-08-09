package com.xzcode.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyChannelRegistryApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(MyChannelRegistryApplication.class, args);
	}
}
