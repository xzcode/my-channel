package com.xzcode.product.app.service.facade.admin;

import java.util.List;
import java.util.Map;

import com.xzcode.product.app.service.facade.IBaseService;
import com.xzcode.product.common.entity.admin.AdminPermission;

/**
 * 管理员权限 service 接口
 * 
 * @author zai
 * 2017-07-26 11:39:06
 */
public interface IAdminPermissionService extends IBaseService<AdminPermission>{

	List<Map<String, Object>> getAdminUserPermissions(Long adminUserId);

	

}

	


