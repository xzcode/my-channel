package com.xzcode.product.app.controller.about;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;


@Controller
@RequestMapping("/about")
public class AboutController {
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@Autowired
	private IAdminPermissionService adminPermissionService;
	
	@RequestMapping("/about_us")
	public String index() {
		return "about/about_us";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "about/contact";
	}

    
}
