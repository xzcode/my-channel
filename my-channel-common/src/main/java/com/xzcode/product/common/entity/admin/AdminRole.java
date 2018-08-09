package com.xzcode.product.common.entity.admin;

import java.util.Date;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;

/**
 * 用户角色 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:02
 */
@Entity
@Table(name = "admin_role")
public class AdminRole {

	/**
	 * 用户角色 表名
	 */
	public static final String __ = "admin_role";

	//列名常量
	
	/**
	 * 自增主键
	 */
	public static final String UID = "uid";
	
	/**
	 * 父角色id
	 */
	public static final String PARENT_ID = "parent_id";
	
	/**
	 * 角色编码
	 */
	public static final String ROLE = "role";
	
	/**
	 * 角色名称
	 */
	public static final String ROLE_NAME = "role_name";
	
	/**
	 * 角色类型[0 普通角色 role; 1 部门 dept]
	 */
	public static final String TYPE = "type";
	
	/**
	 * 创建日期
	 */
	public static final String CREATE_DATE = "create_date";
	
	/**
	 * 创建人
	 */
	public static final String CREATE_BY = "create_by";
	
	/**
	 * 备注
	 */
	public static final String REMARK = "remark";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 * 自增主键 -- (属性名称) 
		 */
		public static final String UID = "uid";
		/**
		 * 父角色id -- (属性名称) 
		 */
		public static final String PARENT_ID = "parentId";
		/**
		 * 角色编码 -- (属性名称) 
		 */
		public static final String ROLE = "role";
		/**
		 * 角色名称 -- (属性名称) 
		 */
		public static final String ROLE_NAME = "roleName";
		/**
		 * 角色类型[0 普通角色 role; 1 部门 dept] -- (属性名称) 
		 */
		public static final String TYPE = "type";
		/**
		 * 创建日期 -- (属性名称) 
		 */
		public static final String CREATE_DATE = "createDate";
		/**
		 * 创建人 -- (属性名称) 
		 */
		public static final String CREATE_BY = "createBy";
		/**
		 * 备注 -- (属性名称) 
		 */
		public static final String REMARK = "remark";
	};
	
	/**
	 * 角色类型 常量类 
	 */
	public static class TypeConstant {
		/**
		 * 普通角色   
		 */
		public static final int ROLE = 0;
		/**
		 * 部门   
		 */
		public static final int DEPT = 1;
	};
	


	/**
	 * 自增主键
	 */
	@Id
	@Column(name = UID)
	private Long uid;
	
	/**
	 * 父角色id
	 */
	
	@Column(name = PARENT_ID)
	private Long parentId;
	
	/**
	 * 角色编码
	 */
	
	@Column(name = ROLE)
	private String role;
	
	/**
	 * 角色名称
	 */
	
	@Column(name = ROLE_NAME)
	private String roleName;
	
	/**
	 * 角色类型[0 普通角色 role; 1 部门 dept]
	 */
	
	@Column(name = TYPE)
	private Integer type;
	
	/**
	 * 创建日期
	 */
	
	@Column(name = CREATE_DATE)
	private Date createDate;
	
	/**
	 * 创建人
	 */
	
	@Column(name = CREATE_BY)
	private Long createBy;
	
	/**
	 * 备注
	 */
	
	@Column(name = REMARK)
	private String remark;
	



	
	
	/**
	 * 自增主键
	 */
	public Long getUid() {
		return this.uid;	
	}
	
	/**
	 * 自增主键
	 */
	public void setUid(Long uid) {
		this.uid = uid;	
	}
	
	
	
	/**
	 * 父角色id
	 */
	public Long getParentId() {
		return this.parentId;	
	}
	
	/**
	 * 父角色id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;	
	}
	
	
	
	/**
	 * 角色编码
	 */
	public String getRole() {
		return this.role;	
	}
	
	/**
	 * 角色编码
	 */
	public void setRole(String role) {
		this.role = role;	
	}
	
	
	
	/**
	 * 角色名称
	 */
	public String getRoleName() {
		return this.roleName;	
	}
	
	/**
	 * 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;	
	}
	
	
	
	/**
	 * 角色类型[0 普通角色 role; 1 部门 dept]
	 */
	public Integer getType() {
		return this.type;	
	}
	
	/**
	 * 角色类型[0 普通角色 role; 1 部门 dept]
	 */
	public void setType(Integer type) {
		this.type = type;	
	}
	
	
	
	/**
	 * 创建日期
	 */
	public Date getCreateDate() {
		return this.createDate;	
	}
	
	/**
	 * 创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;	
	}
	
	
	
	/**
	 * 创建人
	 */
	public Long getCreateBy() {
		return this.createBy;	
	}
	
	/**
	 * 创建人
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;	
	}
	
	
	
	/**
	 * 备注
	 */
	public String getRemark() {
		return this.remark;	
	}
	
	/**
	 * 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;	
	}
	
	
	

}
