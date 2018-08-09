package com.xzcode.product.app.service.impl.admin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.admin.AdminUserRoleMapper;
import com.xzcode.product.app.service.facade.admin.IAdminUserRoleService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.admin.AdminUserRole;




/**
 * 系统用户角色表 service
 * 
 * @author zai & code generator
 * 2017-07-31 11:47:09
 */
@Service
public class AdminUserRoleService extends BaseService<AdminUserRole> implements IAdminUserRoleService{
	
	@Autowired
	private AdminUserRoleMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


