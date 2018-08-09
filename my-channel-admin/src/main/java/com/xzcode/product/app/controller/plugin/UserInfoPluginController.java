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
import com.xzcode.product.app.service.facade.user.IUserInfoService;
import com.xzcode.product.common.entity.user.UserInfo;

/**
 * 系统用户 controller
 * 
 * @author zai & code generator
 * 2017-07-26 14:26:59
 */
@Controller
@RequestMapping(UserInfoPluginController.basePath)
public class UserInfoPluginController{
	
	public static final String basePath = "plugin/user";
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Autowired
	private JdbcLink jdbcLink;

	
	@RequestMapping(value = "/search")
    public ModelAndView viewList(
    		HttpServletRequest request,
    		ModelAndView mav, 
    		Integer pageNo,
    		@RequestParam(required = false, defaultValue="5") Integer pageSize,
    		String keyword,
    		Integer authType,
    		Long currentStarId
    		){
		mav.addObject("authType", authType);
		mav.addObject("currentStarId", currentStarId);
		Pager<Map<String, Object>> pager = 
				
		this.jdbcLink
			.select(UserInfo.class)
			.where()
				.andGroup()
				.or(keyword != null).fuzzyLike(UserInfo.MOBILE, keyword)
				.or(keyword != null).fuzzyLike(UserInfo.USERNAME, keyword)
				.endGroup()
				//.and().eq(UserInfo.AUTH_TYPE, authType)
				.and(currentStarId != null).notIn(UserInfo.UID, new Object[] {
						currentStarId
				})
				
				
			.orderByDesc(UserInfo.CREATE_DATE)
			
			.limit(pageNo, pageSize)
			
			.pageListMap();
		
		mav.addObject("pager", pager);
		
		mav.setViewName(basePath + "/user_search");
    	return mav;
    }

	
	
}
