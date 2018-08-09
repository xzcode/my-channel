package com.xzcode.product.app.service.impl.admin;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.admin.AdminRoleMapper;
import com.xzcode.product.app.service.facade.admin.IAdminRoleService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.admin.AdminPermission;
import com.xzcode.product.common.entity.admin.AdminRole;
import com.xzcode.product.common.entity.admin.AdminRolePermission;
import com.xzcode.product.common.entity.admin.AdminUser;
import com.xzcode.product.common.entity.admin.AdminUserRole;




/**
 * 管理员角色 service
 * 
 * @author zai & code generator
 * 2017-07-26 11:39:06
 */
@Service
public class AdminRoleService extends BaseService<AdminRole> implements IAdminRoleService{
	
	@Autowired
	private AdminRoleMapper mapper;
	
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

	@Override
	public List<AdminRole> getAdminUserRoles(Long adminUserId) {
		
		return this.jdbcLink
	    		.select(AdminRole.class, "ar")
	    			.column("ar", "*")
				.leftJoin(AdminUserRole.class, "aur")
	    			.on().eq("aur", AdminUserRole.ROLE_ID, "ar", AdminRole.UID)
				.leftJoin(AdminUser.class, "au")
	    			.on().eq("ar", AdminUser.UID, "aur", AdminUserRole.ROLE_ID)
    			.where()
    				.and().eq("au", AdminUser.UID, adminUserId)
	    		.queryList();
		
		//return mapper.getAdminUserRoles(adminUserId);
	}
	
	@Override
	public List<AdminPermission> getRolePermissions(Long roleId) {
		return this.jdbcLink
    		.select(AdminPermission.class, "ap")
    			.column("ap", "*")
			.leftJoin(AdminRolePermission.class, "arp")
    			.on().eq("ap", AdminPermission.UID, "arp", AdminRolePermission.PERMISSION_ID)
			.leftJoin(AdminRole.class, "ar")
    			.on().eq("ar", AdminRole.UID, "arp", AdminRolePermission.ROLE_ID)
    		.where()
    			.and().eq("ar", AdminRole.UID, roleId)
    		.queryList();
	}

	@Transactional
	@Override
	public void updateRolePermission(AdminRole editObj, Long[] nodes) {
		
		this.deleteRolePermission(editObj.getUid());
		
		this.jdbcLink.update(editObj);
    	
    	AdminRolePermission adminRolePermission = null;
    	if (nodes.length > 0) {
    		for (Long permissionId : nodes) {
    			adminRolePermission = new AdminRolePermission();
    			adminRolePermission.setRoleId(editObj.getUid());
    			adminRolePermission.setPermissionId(permissionId);
    			this.jdbcLink.insert(adminRolePermission, false);
			}
		}
	}

	@Override
	public void deleteRolePermission(Long roleId) {
		
		this.jdbcLink
		.delete(AdminRolePermission.class)
		.where()
			.and().eq(AdminRolePermission.ROLE_ID, roleId)
		.execute();
		
	}

}

	


