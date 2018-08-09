package com.xzcode.product.app.service.facade.admin;

import com.xzcode.product.app.service.facade.IBaseService;
import com.xzcode.product.common.entity.admin.AdminUser;

/**
 * 系统用户 service 接口
 * 
 * @author zai
 * 2017-06-27 17:16:18
 */
public interface IAdminUserService extends IBaseService<AdminUser>{

	AdminUser getAdminUserByUserName(String username);

}

	


