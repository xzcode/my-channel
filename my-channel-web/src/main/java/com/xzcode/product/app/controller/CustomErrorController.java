package com.xzcode.product.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xzcode.jdbclink.core.JdbcLink;


@Controller
public class CustomErrorController implements ErrorController{
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@RequestMapping("/error")
	public String index(
			HttpServletRequest request,
			HttpServletResponse response
			) {
		if (response.getStatus() == 404) {
			return "error/404";			
		} 
		return "error/500";		
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

    
}
