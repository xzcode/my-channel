package com.xzcode.product.app.controller.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;


@Controller
@RequestMapping("/solution")
public class SolutionController {
	
	@Autowired
	private JdbcLink jdbcLink;
	
	

	@RequestMapping("/house_solution")
	public String houseSolution() {
		return "solution/house_solution";
	}
	
	@RequestMapping("/office_solution")
	public String officeSolution() {
		return "solution/office_solution";
	}
	
    
}
