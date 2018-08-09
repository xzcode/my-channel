package com.xzcode.product.app.service.facade.user;

import com.xzcode.product.app.service.facade.IBaseService;
import com.xzcode.product.common.entity.user.UserInfo;

/**
 * 用户基本信息表 service 接口
 * 
 * @author zai
 * 2018-04-16 17:10:09
 */
public interface IUserInfoService extends IBaseService<UserInfo>{

	/**
	 * 通过绑定的手机号码获取有效的用户信息
	 * @param mobile
	 * @return
	 */
	UserInfo getUserByMobile(String mobile);
	
	/**
	 * 通过账号密码获取有效的用户信息
	 * @param mobile
	 * @param password
	 * @return
	 */
	UserInfo getUserByMobileAndPassword(String mobile, String password);
	
	/**
	 * 注册用户
	 * @param mobile
	 * @param password
	 * @return
	 */
	int registerUser(String mobile, String password);
	
	
}

	


