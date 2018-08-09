package com.xzcode.product.app.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;
import com.xzcode.product.app.utils.SessionUtils;
import com.xzcode.product.common.entity.admin.AdminPermission;
import com.xzcode.product.common.entity.admin.AdminUser;
import com.xzcode.product.common.util.AjaxResponse;


@Controller
@RequestMapping
public class IndexController {
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@Autowired
	private IAdminPermissionService adminPermissionService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) throws Exception{
    	AdminUser user = SessionUtils.getUser();
    	
    	// 根据用户名查询当前用户拥有的角色
    	AdminUser adminUser = SessionUtils.getUser();
        
        // 根据用户名查询当前用户权限
        List<Map<String, Object>> permissions = this.adminPermissionService.getAdminUserPermissions(adminUser.getUid());
        
        
        
        List<Map<String, Object>> level1 = permissions
        		.stream()
        		.filter(x -> Integer.valueOf(1).equals(x.get(AdminPermission.PropName.DEEP)) && Integer.valueOf(1).equals(x.get(AdminPermission.PropName.IS_MENU)))
        		.map(x -> {
        			
        			List<Map<String, Object>> level2 = permissions
        	        		.stream()
        	        		.filter(x2 -> {
        	        			return 
        	        					Integer.valueOf(2).equals(x2.get(AdminPermission.PropName.DEEP)) 
        	        					&& 
        	        					Integer.valueOf(1).equals(x2.get(AdminPermission.PropName.IS_MENU))
        	        					&&
        	        					x2.get(AdminPermission.PropName.PARENT_ID).equals(x.get(AdminPermission.PropName.UID))
        	        					;
        	        		})
        	        		.map(x2 -> {
        	        			List<Map<String, Object>> level3 = permissions
        	        	        		.stream()
        	        	        		.filter(x3 -> {
        	        	        			return 
        	        	        					Integer.valueOf(3).equals(x3.get(AdminPermission.PropName.DEEP)) 
        	        	        					&& 
        	        	        					Integer.valueOf(1).equals(x3.get(AdminPermission.PropName.IS_MENU))
        	        	        					&&
        	        	        					x3.get(AdminPermission.PropName.PARENT_ID).equals(x2.get(AdminPermission.PropName.UID))
        	        	        					;
        	        	        		} )
        	        	        		.collect(Collectors.toList());
        	        			x2.put("children",level3);
        	        			return x2;
        	        		})
        	        		.collect(Collectors.toList());
        			
        			x.put("children",level2);
        			return x;
        		})
        		.collect(Collectors.toList());
        
        
        
        mav.addObject("menus", level1);
    	
    	
        mav.addObject("user", user);
        mav.setViewName("index");
	    return mav;
		
    }
    
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String home() throws Exception{
    	
	    return "home";
		
    }
    
    
    @RequestMapping(value = "changepassword",method = RequestMethod.GET)
    public String changePassword(ModelMap modelMap) throws Exception{
	    return "changepassword";
    }
    
    @RequestMapping(value = "changepassword/submit",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse changePassword(
    		@RequestParam String password,
    		@RequestParam String oldPassword
    		) throws Exception{
    	
    	AdminUser user = SessionUtils.getUser();
    	
    	if (!oldPassword.equals(user.getPassword())) {
			return AjaxResponse.fail("旧密码错误!");
		}
    	
		this.jdbcLink.update(AdminUser.class)
		.set()
			.param(AdminUser.PASSWORD, password)
		.where()
			.and().eq(AdminUser.UID, user.getUid())
			.and().eq(AdminUser.PASSWORD, oldPassword)
		.execute()
		;
		
		user.setPassword(password);
		
		return AjaxResponse.success();
    }
    
}
