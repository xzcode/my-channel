package com.xzcode.product.app.service.impl.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.user.UserInfoMapper;
import com.xzcode.product.app.service.facade.user.IUserInfoService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.user.UserInfo;




/**
 * 用户基本信息表 service
 * 
 * @author zai & code generator
 * 2018-04-16 16:59:03
 */
@Service
public class UserInfoService extends BaseService<UserInfo> implements IUserInfoService{
	
	@Autowired
	private UserInfoMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}
	
	@Override
	public UserInfo getUserByMobile(String mobile) {
		return jdbcLink
				.select(UserInfo.class)
				.where()
				.and().eq(UserInfo.MOBILE, mobile)
				.queryEntity();
	}
	
	@Override
	public UserInfo getUserByMobileAndPassword(String mobile, String password) {
		return jdbcLink
				.select(UserInfo.class)
				.where()
				.and().eq(UserInfo.MOBILE, mobile)
				.and().eq(UserInfo.PASSWORD, password)
				.and().eq(UserInfo.ENABLED, UserInfo.EnabledConstant.YES)
				.queryEntity();
	}

	@Override
	public int registerUser(String mobile, String password) {
		// TODO Auto-generated method stub
		return 0;
	}


}

	


