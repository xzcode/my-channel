package com.xzcode.product.common.entity.admin;

import java.util.Date;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;

/**
 * 系统用户表 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:02
 */
@Entity
@Table(name = "admin_user")
public class AdminUser {

	/**
	 * 系统用户表 表名
	 */
	public static final String __ = "admin_user";

	//列名常量
	
	/**
	 * 自增主键
	 */
	public static final String UID = "uid";
	
	/**
	 * 用户帐号
	 */
	public static final String USERNAME = "username";
	
	/**
	 * md5密码
	 */
	public static final String PASSWORD = "password";
	
	/**
	 * 真实姓名
	 */
	public static final String REALNAME = "realname";
	
	/**
	 * md5加盐
	 */
	public static final String SALT = "salt";
	
	/**
	 * 手机号码
	 */
	public static final String MOBILE = "mobile";
	
	/**
	 * 头像
	 */
	public static final String AVATAR = "avatar";
	
	/**
	 * 创建日期
	 */
	public static final String CREATE_DATE = "create_date";
	
	/**
	 * 更新日期
	 */
	public static final String UPDATE_DATE = "update_date";
	
	/**
	 * 启用状态[0 禁用 no; 1 启用 yes]
	 */
	public static final String ENABLED = "enabled";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 * 自增主键 -- (属性名称) 
		 */
		public static final String UID = "uid";
		/**
		 * 用户帐号 -- (属性名称) 
		 */
		public static final String USERNAME = "username";
		/**
		 * md5密码 -- (属性名称) 
		 */
		public static final String PASSWORD = "password";
		/**
		 * 真实姓名 -- (属性名称) 
		 */
		public static final String REALNAME = "realname";
		/**
		 * md5加盐 -- (属性名称) 
		 */
		public static final String SALT = "salt";
		/**
		 * 手机号码 -- (属性名称) 
		 */
		public static final String MOBILE = "mobile";
		/**
		 * 头像 -- (属性名称) 
		 */
		public static final String AVATAR = "avatar";
		/**
		 * 创建日期 -- (属性名称) 
		 */
		public static final String CREATE_DATE = "createDate";
		/**
		 * 更新日期 -- (属性名称) 
		 */
		public static final String UPDATE_DATE = "updateDate";
		/**
		 * 启用状态[0 禁用 no; 1 启用 yes] -- (属性名称) 
		 */
		public static final String ENABLED = "enabled";
	};
	
	/**
	 * 启用状态 常量类 
	 */
	public static class EnabledConstant {
		/**
		 * 禁用   
		 */
		public static final int NO = 0;
		/**
		 * 启用   
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
	 * 用户帐号
	 */
	
	@Column(name = USERNAME)
	private String username;
	
	/**
	 * md5密码
	 */
	
	@Column(name = PASSWORD)
	private String password;
	
	/**
	 * 真实姓名
	 */
	
	@Column(name = REALNAME)
	private String realname;
	
	/**
	 * md5加盐
	 */
	
	@Column(name = SALT)
	private String salt;
	
	/**
	 * 手机号码
	 */
	
	@Column(name = MOBILE)
	private String mobile;
	
	/**
	 * 头像
	 */
	
	@Column(name = AVATAR)
	private String avatar;
	
	/**
	 * 创建日期
	 */
	
	@Column(name = CREATE_DATE)
	private Date createDate;
	
	/**
	 * 更新日期
	 */
	
	@Column(name = UPDATE_DATE)
	private Date updateDate;
	
	/**
	 * 启用状态[0 禁用 no; 1 启用 yes]
	 */
	
	@Column(name = ENABLED)
	private Integer enabled;
	



	
	
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
	 * 用户帐号
	 */
	public String getUsername() {
		return this.username;	
	}
	
	/**
	 * 用户帐号
	 */
	public void setUsername(String username) {
		this.username = username;	
	}
	
	
	
	/**
	 * md5密码
	 */
	public String getPassword() {
		return this.password;	
	}
	
	/**
	 * md5密码
	 */
	public void setPassword(String password) {
		this.password = password;	
	}
	
	
	
	/**
	 * 真实姓名
	 */
	public String getRealname() {
		return this.realname;	
	}
	
	/**
	 * 真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;	
	}
	
	
	
	/**
	 * md5加盐
	 */
	public String getSalt() {
		return this.salt;	
	}
	
	/**
	 * md5加盐
	 */
	public void setSalt(String salt) {
		this.salt = salt;	
	}
	
	
	
	/**
	 * 手机号码
	 */
	public String getMobile() {
		return this.mobile;	
	}
	
	/**
	 * 手机号码
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;	
	}
	
	
	
	/**
	 * 头像
	 */
	public String getAvatar() {
		return this.avatar;	
	}
	
	/**
	 * 头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;	
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
	 * 更新日期
	 */
	public Date getUpdateDate() {
		return this.updateDate;	
	}
	
	/**
	 * 更新日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;	
	}
	
	
	
	/**
	 * 启用状态[0 禁用 no; 1 启用 yes]
	 */
	public Integer getEnabled() {
		return this.enabled;	
	}
	
	/**
	 * 启用状态[0 禁用 no; 1 启用 yes]
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;	
	}
	
	
	

}
