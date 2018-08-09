package com.xzcode.product.common.exception;

/**
 * 通用业务异常
 * 
 * @author zai
 * 2017-03-25 03:37:27
 */
public class BizException extends RuntimeException {
	private static final long serialVersionUID = -1715907038757557299L;

	
	
	
	public BizException() {
		super();
	}

	public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(String message) {
		super(message);
	}
	
	/**
	 * 修改 fillInStackTrace 不填充线程栈 提高业务异常抛出性能
	 * @return
	 * @author zai
	 * 2017-03-25 03:54:14
	 */
	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
	
	public static BizException throwz(String message) {
		return new BizException(message);
	}
	
	
	
}
