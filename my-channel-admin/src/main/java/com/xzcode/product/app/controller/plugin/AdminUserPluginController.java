package com.xzcode.product.app.controller.plugin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.jdbclink.core.models.Pager;
import com.xzcode.product.app.service.facade.admin.IAdminUserService;
import com.xzcode.product.common.entity.admin.AdminRole;
import com.xzcode.product.common.entity.admin.AdminUser;
import com.xzcode.product.common.entity.admin.AdminUserRole;

/**
 * 系统用户 controller
 * 
 * @author zai & code generator
 * 2017-07-26 14:26:59
 */
@Controller
@RequestMapping(AdminUserPluginController.basePath)
public class AdminUserPluginController{
	
	public static final String basePath = "plugin/admin";
	
	@Autowired
	private IAdminUserService adminUserService;
	
	@Autowired
	private JdbcLink jdbcLink;

	
	@RequestMapping(value = "/search")
    public ModelAndView viewList(
    		HttpServletRequest request,
    		ModelAndView mav, 
    		Integer pageNo,
    		@RequestParam(required = false, defaultValue="5") Integer pageSize,
    		String keyword
    		){
		
		Pager<Map<String, Object>> pager = 
				
		this.jdbcLink
			.select(AdminUser.class, "au")
				.column("au", "*")
			.column("ar", AdminRole.ROLE_NAME)
				
			.leftJoin(AdminUserRole.class, "aur")
				.on().eq("aur", AdminUserRole.USER_ID, "au", AdminUser.UID)
			.leftJoin(AdminRole.class, "ar")
				.on().eq("aur", AdminUserRole.ROLE_ID, "ar", AdminRole.UID)
			.where()
				.or(keyword != null).fuzzyLike("au",AdminUser.REALNAME, keyword)
				.or(keyword != null).fuzzyLike("au",AdminUser.MOBILE, keyword)
				.or(keyword != null).fuzzyLike("au",AdminUser.USERNAME, keyword)
				
			.orderByDesc("au", AdminUser.CREATE_DATE)
			
			.limit(pageNo, pageSize)
			
			.pageListMap();
		
		mav.addObject("pager", pager);
		mav.setViewName(basePath + "/admin_search");
    	return mav;
    }

	
	
}
