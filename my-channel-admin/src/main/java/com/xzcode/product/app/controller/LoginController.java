package com.xzcode.product.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * 登录页面controller
 * 
 * 
 * @author zai
 * 2018-03-29
 */
@Controller
@RequestMapping
public class LoginController {
	
	//@Autowired
	//private JdbcLink jdbcLink;
	
	//登录与登出 已在spring security 配置中实现
	
	
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public  String login(ModelMap modelMap) throws Exception{
	    return "login";
    }
    
    
}
