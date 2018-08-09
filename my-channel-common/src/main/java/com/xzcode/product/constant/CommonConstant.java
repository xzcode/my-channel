package com.xzcode.product.constant;

public class CommonConstant {
	
	public static final int NOT_LIMIT = -1;
	public static final long NOT_LIMIT_LONG = -1L;
	public static final String INIT_ORDER_NO = "InitOrderNo";		// 初始化订单号
	public static final String NULL = "null";
	
	public class UserConstant{
		public static final String I_LOCATION = "未设置";
		public static final String I_USERNAME = "用户:%s";
	}
	
	public class SystemConfigConstant {
		// 短信超时时间
		public final static String RONGLIAN_SMS_CODE_OVERTIME = "RonglianSmsCodeOverTime";
		// 发送注册或者重置密码短信模板
		public final static String REGIST_FINDPASSWORD_TEMPLATE = "RegistTemplateCode";
		// 用户多次登录失败允许下次进行登录操作的时间间隔(秒)
		public final static  String USER_MULTILOGINFAIL_ALLOW_NEXTLOGIN_TIMEINTERVAL = "UserMultiLoginFailAllowNextLoginTimeInterval";
		// 用户连续登录几次失败后开始做限制
		public final static String USER_LOGIN_FAIL_START_LIMIT_COUNT = "UserLoginFailStartLimitCount";
		// 用户登录有效期(天)
		public final static String LOGIN_OVER_TIME = "LoginOverTime";
		// 客服电话
		public final static String CUSTOMER_SERVICE_NUMBER = "CustomerServiceNumber";
		// 订单超时时间(秒)
		public final static String ORDER_OVER_TIME = "OrderOverTime";
		// 发货后自动设置为确认收货(即完成)时长(天)
		public final static String COMPLETE_OVER_DAY = "CompleteOverDay";
	}
	
	public class DeviceTypeConstant {
		//IOS
		public final static String MOBILE_IOS = "mobile_ios";
		//安卓
		public final static String MOBILE_ANDROID = "mobile_android";
	}
	
	public class RecordAlias {
		public final static String CASH = "提现";
		public final static String BORROW = "借阅图书《%s》";
		public final static String RENEW = "续借图书《%s》";
		public final static String INCOME = "收入";
		public final static String RECHARGE = "充值";
	}
	
	public class Alias{
		
		public final static String ADDRESS_ID = "addressId";
		public final static String ARTICLE_ID = "articleId";
		public final static String VIDEO_ID = "videoId";
		public final static String BOOK_ID = "bookId";
		public final static String BOOK_BAR_ID = "bookBarId";
		public final static String PRODUCT_ID = "productId";
		
		public final static String IS_LIKE = "isLike";
		public final static String IS_COLLECTION = "isCollection";
	}
	
	public interface PushMessageType {
		
	}
	
}
