package com.xzcode.sfs.service.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestTimeInteceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(RequestTimeInteceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		if (logger.isInfoEnabled()) {
			
	        logger.info(
	        		"[{}] executeTime : {}ms",
	        		 request.getRequestURI(),
	        		(System.currentTimeMillis() - (long)request.getAttribute("rti_startTime"))
	        		);  
		}
		
	}
 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object handler, ModelAndView arg3)
			throws Exception {
        
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		if (logger.isInfoEnabled()) {
			request.setAttribute("rti_startTime", System.currentTimeMillis());  
		}
        return true;
	}


}
