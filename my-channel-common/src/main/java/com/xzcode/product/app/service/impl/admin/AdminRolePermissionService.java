package com.xzcode.product.app.service.impl.admin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.admin.AdminRolePermissionMapper;
import com.xzcode.product.app.service.facade.admin.IAdminRolePermissionService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.admin.AdminRolePermission;




/**
 * 用户权限角色对应关系表 service
 * 
 * @author zai & code generator
 * 2017-07-31 11:47:08
 */
@Service
public class AdminRolePermissionService extends BaseService<AdminRolePermission> implements IAdminRolePermissionService{
	
	@Autowired
	private AdminRolePermissionMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


