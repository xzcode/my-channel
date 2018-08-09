package com.xzcode.product.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xzcode.product.common.exception.BizException;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 异常处理
 * @author wulizhou
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 验证异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public AjaxResponse handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex){
		String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		return AjaxResponse.exceptionResult(message);
	}
	
	/**
	 * 自定义异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(BizException.class)
	public AjaxResponse handleBizException(HttpServletRequest request, BizException ex){
		String message = ex.getMessage();
		return AjaxResponse.exceptionResult(message);
	}
	
	/*@ExceptionHandler(UnauthorizedException.class)
	public AjaxResponse handleUnauthorizedException(HttpServletRequest request, BizException ex){
		String message = ex.getMessage();
		return AjaxResponse.exceptionResult(message);
	}*/
	
	/**
	 * 其它未知异常
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)  
    public AjaxResponse handleException(HttpServletRequest request, Exception ex) { 
		logger.error("未知异常", ex);
        return AjaxResponse.exceptionResult();
    }  
       
}
