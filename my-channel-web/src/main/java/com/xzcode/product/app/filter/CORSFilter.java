package com.xzcode.product.app.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 跨域支持过滤器
 * 
 * @author zai
 * 2017-08-09
 */
public class CORSFilter extends OncePerRequestFilter {
	
	/**
	 * CORS过滤
	 */
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Headers", "X-Requested-With,x_requested_with,X-File-Name");
			filterChain.doFilter(request, response);
	}
	
	

}