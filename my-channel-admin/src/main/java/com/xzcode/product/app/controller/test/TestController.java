package com.xzcode.product.app.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.controller.test.model.JsonToDateTestModel;
import com.xzcode.product.app.service.facade.system.ISystemConfigService;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * test controller
 * 
 * 
 * @author zai
 * 2017-08-30
 */
@Controller
@RequestMapping(TestController.basePath)
public class TestController{
	
	public static final String basePath = "test";
	
	@Autowired
	private ISystemConfigService systemConfigService;
	
	@Autowired
	private JdbcLink jdbcLink;

    
    @RequestMapping(value = "/json/datetime")
    @ResponseBody
    public AjaxResponse ajaxAddSave(@RequestBody JsonToDateTestModel model){
    	
    	return AjaxResponse.success().setData(model);
    }
    
	
	
}
