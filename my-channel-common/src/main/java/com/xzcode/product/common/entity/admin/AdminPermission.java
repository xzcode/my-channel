package com.xzcode.product.common.entity.admin;

import java.util.Date;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;

/**
 * 用户权限 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:02
 */
@Entity
@Table(name = "admin_permission")
public class AdminPermission {

	/**
	 * 用户权限 表名
	 */
	public static final String __ = "admin_permission";

	//列名常量
	
	/**
	 * 自增主键
	 */
	public static final String UID = "uid";
	
	/**
	 * 父权限id
	 */
	public static final String PARENT_ID = "parent_id";
	
	/**
	 * 权限编码
	 */
	public static final String PERMISSION = "permission";
	
	/**
	 * 权限名
	 */
	public static final String PERMISSION_NAME = "permission_name";
	
	/**
	 * 层次深度
	 */
	public static final String DEEP = "deep";
	
	/**
	 * 是否为菜单[0 否 no; 1 是 yes]
	 */
	public static final String IS_MENU = "is_menu";
	
	/**
	 * 权限url
	 */
	public static final String URL_PATTERN = "url_pattern";
	
	/**
	 * 图标标识
	 */
	public static final String MENU_ICON = "menu_icon";
	
	/**
	 * 排序
	 */
	public static final String SORT_ORDER = "sort_order";
	
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
		 * 父权限id -- (属性名称) 
		 */
		public static final String PARENT_ID = "parentId";
		/**
		 * 权限编码 -- (属性名称) 
		 */
		public static final String PERMISSION = "permission";
		/**
		 * 权限名 -- (属性名称) 
		 */
		public static final String PERMISSION_NAME = "permissionName";
		/**
		 * 层次深度 -- (属性名称) 
		 */
		public static final String DEEP = "deep";
		/**
		 * 是否为菜单[0 否 no; 1 是 yes] -- (属性名称) 
		 */
		public static final String IS_MENU = "isMenu";
		/**
		 * 权限url -- (属性名称) 
		 */
		public static final String URL_PATTERN = "urlPattern";
		/**
		 * 图标标识 -- (属性名称) 
		 */
		public static final String MENU_ICON = "menuIcon";
		/**
		 * 排序 -- (属性名称) 
		 */
		public static final String SORT_ORDER = "sortOrder";
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
	 * 是否为菜单 常量类 
	 */
	public static class IsMenuConstant {
		/**
		 * 否   
		 */
		public static final int NO = 0;
		/**
		 * 是   
		 */
		public static final int YES = 1;
	};
	


	/**
	 * 自增主键
	 */
	@Id
	@Column(name = UID)
	private Long uid;
	
	/**
	 * 父权限id
	 */
	
	@Column(name = PARENT_ID)
	private Long parentId;
	
	/**
	 * 权限编码
	 */
	
	@Column(name = PERMISSION)
	private String permission;
	
	/**
	 * 权限名
	 */
	
	@Column(name = PERMISSION_NAME)
	private String permissionName;
	
	/**
	 * 层次深度
	 */
	
	@Column(name = DEEP)
	private Integer deep;
	
	/**
	 * 是否为菜单[0 否 no; 1 是 yes]
	 */
	
	@Column(name = IS_MENU)
	private Integer isMenu;
	
	/**
	 * 权限url
	 */
	
	@Column(name = URL_PATTERN)
	private String urlPattern;
	
	/**
	 * 图标标识
	 */
	
	@Column(name = MENU_ICON)
	private String menuIcon;
	
	/**
	 * 排序
	 */
	
	@Column(name = SORT_ORDER)
	private Integer sortOrder;
	
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
	 * 父权限id
	 */
	public Long getParentId() {
		return this.parentId;	
	}
	
	/**
	 * 父权限id
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;	
	}
	
	
	
	/**
	 * 权限编码
	 */
	public String getPermission() {
		return this.permission;	
	}
	
	/**
	 * 权限编码
	 */
	public void setPermission(String permission) {
		this.permission = permission;	
	}
	
	
	
	/**
	 * 权限名
	 */
	public String getPermissionName() {
		return this.permissionName;	
	}
	
	/**
	 * 权限名
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;	
	}
	
	
	
	/**
	 * 层次深度
	 */
	public Integer getDeep() {
		return this.deep;	
	}
	
	/**
	 * 层次深度
	 */
	public void setDeep(Integer deep) {
		this.deep = deep;	
	}
	
	
	
	/**
	 * 是否为菜单[0 否 no; 1 是 yes]
	 */
	public Integer getIsMenu() {
		return this.isMenu;	
	}
	
	/**
	 * 是否为菜单[0 否 no; 1 是 yes]
	 */
	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;	
	}
	
	
	
	/**
	 * 权限url
	 */
	public String getUrlPattern() {
		return this.urlPattern;	
	}
	
	/**
	 * 权限url
	 */
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;	
	}
	
	
	
	/**
	 * 图标标识
	 */
	public String getMenuIcon() {
		return this.menuIcon;	
	}
	
	/**
	 * 图标标识
	 */
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;	
	}
	
	
	
	/**
	 * 排序
	 */
	public Integer getSortOrder() {
		return this.sortOrder;	
	}
	
	/**
	 * 排序
	 */
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;	
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
