package com.xzcode.sfs.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@MapperScan("com.xzcode.sfs.core.dao")
@EnableTransactionManagement
@ServletComponentScan
public class ZjwlFilesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ZjwlFilesApplication.class, args);
	}
}
