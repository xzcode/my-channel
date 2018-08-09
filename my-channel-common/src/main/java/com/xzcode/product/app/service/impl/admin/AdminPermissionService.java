package com.xzcode.product.app.service.impl.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.admin.AdminPermissionMapper;
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.admin.AdminPermission;
import com.xzcode.product.common.entity.admin.AdminRole;
import com.xzcode.product.common.entity.admin.AdminRolePermission;
import com.xzcode.product.common.entity.admin.AdminUser;
import com.xzcode.product.common.entity.admin.AdminUserRole;




/**
 * 管理员权限 service
 * 
 * @author zai & code generator
 * 2017-07-26 11:39:06
 */
@Service
public class AdminPermissionService extends BaseService<AdminPermission> implements IAdminPermissionService{
	
	@Autowired
	private AdminPermissionMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

	@Override
	public List<Map<String, Object>> getAdminUserPermissions(Long adminUserId) {
		
		return this.jdbcLink.select(AdminPermission.class, "ar")
				
			.column("ap", "*")
			
			.join(AdminUserRole.class, "aur")
				.on().eq("aur", AdminUserRole.ROLE_ID, "ar", AdminRole.UID)
				
			.join(AdminUser.class, "au")
				.on().eq("au", AdminUser.UID, "aur", AdminUserRole.USER_ID)
				.and().eq("au", AdminUser.UID, adminUserId)
				
			.join(AdminRolePermission.class, "arp")
				.on().eq("arp", AdminRolePermission.ROLE_ID, "ar", AdminRole.UID)
				
			.join(AdminPermission.class, "ap")
				.on().eq("ap", AdminPermission.UID, "arp", AdminRolePermission.PERMISSION_ID)
				
			.orderByAsc("ap", AdminPermission.SORT_ORDER)
			.queryListMap()
		;
		
	}
	
	
}

	


