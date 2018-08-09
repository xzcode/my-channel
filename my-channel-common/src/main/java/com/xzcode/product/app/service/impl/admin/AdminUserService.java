package com.xzcode.product.app.service.impl.admin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.admin.AdminUserMapper;
import com.xzcode.product.app.service.facade.admin.IAdminUserService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.admin.AdminUser;




/**
 * 系统用户 service
 * 
 * @author zai & code generator
 * 2017-06-27 17:16:18
 */
@Service
public class AdminUserService extends BaseService<AdminUser> implements IAdminUserService{
	
	@Autowired
	private AdminUserMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

	@Override
	public AdminUser getAdminUserByUserName(String username) {
		AdminUser adminUser = jdbcLink.select(AdminUser.class)
		.column("*")
		.where()
			.and(username != null).eq(AdminUser.USERNAME, username)
			//.and().eq(AdminUser.DEL_FLAG, AdminUser.DelFlagConstant.NO)
		.queryEntity();
		
		return adminUser;
	}

}

	


