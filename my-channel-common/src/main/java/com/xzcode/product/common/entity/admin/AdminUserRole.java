package com.xzcode.product.common.entity.admin;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Table;


/**
 * 系统用户角色表 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:02
 */
@Entity
@Table(name = "admin_user_role")
public class AdminUserRole {

	/**
	 * 系统用户角色表 表名
	 */
	public static final String __ = "admin_user_role";

	//列名常量
	
	/**
	 * 
	 */
	public static final String USER_ID = "user_id";
	
	/**
	 * 
	 */
	public static final String ROLE_ID = "role_id";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 *  -- (属性名称) 
		 */
		public static final String USER_ID = "userId";
		/**
		 *  -- (属性名称) 
		 */
		public static final String ROLE_ID = "roleId";
	};
	
	


	/**
	 * 
	 */
	
	@Column(name = USER_ID)
	private Long userId;
	
	/**
	 * 
	 */
	
	@Column(name = ROLE_ID)
	private Long roleId;
	



	
	
	/**
	 * 
	 */
	public Long getUserId() {
		return this.userId;	
	}
	
	/**
	 * 
	 */
	public void setUserId(Long userId) {
		this.userId = userId;	
	}
	
	
	
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
	
	
	

}
