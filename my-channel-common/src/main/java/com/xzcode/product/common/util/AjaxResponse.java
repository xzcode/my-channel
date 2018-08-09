package com.xzcode.product.common.util;

/**
 * ajax响应包装类
 * 
 * @author Joy 2015年9月17日 下午3:48:38
 */
public class AjaxResponse {
	
	private boolean success;
	
	/**
	 * 1为成功，非1为失败
	 */
	private Integer code;

	/**
	 * 响应的文字消息
	 */
	private String message;

	/**
	 * 响应数据
	 */
	private Object data;
	
	public AjaxResponse(boolean success){
		this.success = success;
	}

	public Integer getCode() {
		return code;
	}

	public AjaxResponse setCode(Integer code) {
		this.code = code;
		return this;
	}

	public Object getData() {
		return data;
	}

	public AjaxResponse setData(Object data) {
		this.data = data;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public AjaxResponse setMessage(String message) {
		this.message = message;
		return this;
	}

	public static AjaxResponse success() {
		return new AjaxResponse(true).setCode(1);
	}
	
	public static AjaxResponse success(String successMessage) {
		return new AjaxResponse(true).setCode(1).setMessage(successMessage);
	}

	public static AjaxResponse fail() {
		return new AjaxResponse(false).setCode(-1);
	}
	
	public static AjaxResponse fail(String failMessage) {
		return new AjaxResponse(false).setCode(-1).setMessage(failMessage);
	}

	
	public static AjaxResponse exceptionResult(String message){
		return new AjaxResponse(false).setCode(500).setMessage(message);
	}
	
	public static AjaxResponse exceptionResult(){
		return new AjaxResponse(false).setCode(500);
	}

	public AjaxResponse(boolean success, Integer code, String message, Object data) {
		super();
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public AjaxResponse(Integer code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public AjaxResponse(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public AjaxResponse() {
		super();
	}
	
}
