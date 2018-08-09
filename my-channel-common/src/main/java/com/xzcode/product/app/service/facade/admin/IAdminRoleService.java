package com.xzcode.product.app.service.facade.admin;

import java.util.List;

import com.xzcode.product.app.service.facade.IBaseService;
import com.xzcode.product.common.entity.admin.AdminPermission;
import com.xzcode.product.common.entity.admin.AdminRole;

/**
 * 管理员角色 service 接口
 * 
 * @author zai
 * 2017-07-26 11:39:06
 */
public interface IAdminRoleService extends IBaseService<AdminRole>{

	List<AdminRole> getAdminUserRoles(Long uid);
	
	List<AdminPermission> getRolePermissions(Long roleId);
	
	void updateRolePermission(AdminRole editObj, Long[] nodes);
	
	void deleteRolePermission(Long roleId);

}

	


