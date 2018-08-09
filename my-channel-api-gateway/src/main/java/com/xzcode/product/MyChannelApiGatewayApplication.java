package com.xzcode.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MyChannelApiGatewayApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(MyChannelApiGatewayApplication.class, args);
	}
}
