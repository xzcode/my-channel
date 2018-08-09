package com.xzcode.product.common.entity.admin;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Table;


/**
 * 用户权限角色对应关系表 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:02
 */
@Entity
@Table(name = "admin_role_permission")
public class AdminRolePermission {

	/**
	 * 用户权限角色对应关系表 表名
	 */
	public static final String __ = "admin_role_permission";

	//列名常量
	
	/**
	 * 
	 */
	public static final String ROLE_ID = "role_id";
	
	/**
	 * 
	 */
	public static final String PERMISSION_ID = "permission_id";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 *  -- (属性名称) 
		 */
		public static final String ROLE_ID = "roleId";
		/**
		 *  -- (属性名称) 
		 */
		public static final String PERMISSION_ID = "permissionId";
	};
	
	


	/**
	 * 
	 */
	
	@Column(name = ROLE_ID)
	private Long roleId;
	
	/**
	 * 
	 */
	
	@Column(name = PERMISSION_ID)
	private Long permissionId;
	



	
	
	/**
	 * 
	 */
	public Long getRoleId() {
		return this.roleId;	
	}
	
	/**
	 * 
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;	
	}
	
	
	
	/**
	 * 
	 */
	public Long getPermissionId() {
		return this.permissionId;	
	}
	
	/**
	 * 
	 */
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;	
	}
	
	
	

}
