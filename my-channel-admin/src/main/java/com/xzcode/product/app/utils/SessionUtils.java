package com.xzcode.product.app.utils;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xzcode.product.common.entity.admin.AdminUser;
import com.xzcode.product.config.security.springsecurity.ScUserDetails;


/**
 * 管理当前当前登录对象
 * @author laizhilong
 *
 */
public class SessionUtils {

	private SessionUtils(){
		
	}
	
	
	/**
	 * 获取当前Request
	 * @return
	 */
	private static HttpServletRequest getRequest() {  
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();  
        return requestAttributes.getRequest();  
    } 
	
	private static HttpServletResponse getResponse() {  
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
        return requestAttributes.getResponse();
    } 
	
	/**
	 * 获取当前Session
	 * @return
	 */
	private static HttpSession getSession() {  
        return getRequest().getSession();
    }
	
	public static void logout(){
		new SecurityContextLogoutHandler().logout(getRequest(), getResponse(), null);
	}
	
	public static void setAttribute(String key, Object value){
		getSession().setAttribute(key, value);
	}
	
	public static Object getAttribute(String key){
		return getSession().getAttribute(key);
	}
	
	                                                                                       /**
	 * 获取当前session里面放置的User对象
	 * @return
	 * @throws Exception 
	 */
	public static AdminUser getUser(){
		AdminUser user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			ScUserDetails userDetails = (ScUserDetails) authentication.getPrincipal();
			user = (AdminUser)userDetails.getUserEntity();
			if (user == null) {
				logout();
			}
		}
		return user;
		
	}
	
	/**
	 * 把当前User对象放置到session里面
	 * @param user
	 */
	public static void setUser(AdminUser user){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			ScUserDetails userDetails = (ScUserDetails) authentication.getPrincipal();
			userDetails.setUserEntity(user);
		}
	}
	
}
