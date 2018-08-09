package com.xzcode.product.common.entity.user;

import java.util.Date;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;

/**
 * 用户基本信息表 实体类
 * 
 * @author zai
 * 2018-04-17 15:11:13
 */
@Entity
@Table(name = "user_info")
public class UserInfo {

	/**
	 * 用户基本信息表 表名
	 */
	public static final String __ = "user_info";

	//列名常量
	
	/**
	 * 用户标识
	 */
	public static final String UID = "uid";
	
	/**
	 * 手机号
	 */
	public static final String MOBILE = "mobile";
	
	/**
	 * 密码
	 */
	public static final String PASSWORD = "password";
	
	/**
	 * 昵称
	 */
	public static final String USERNAME = "username";
	
	/**
	 * 头像
	 */
	public static final String AVATAR = "avatar";
	
	/**
	 * 邮箱
	 */
	public static final String EMAIL = "email";
	
	/**
	 * 性别[0 女 female; 1 男 male]
	 */
	public static final String SEX = "sex";
	
	/**
	 * 身份类型[0 普通用户 ordinary; 1 vip vip; 2 svip svip]
	 */
	public static final String IDENTITY_TYPE = "identity_type";
	
	/**
	 * 注册时间
	 */
	public static final String CREATE_DATE = "create_date";
	
	/**
	 * 启用状态[0 禁用 no; 1 启用 yes]
	 */
	public static final String ENABLED = "enabled";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 * 用户标识 -- (属性名称) 
		 */
		public static final String UID = "uid";
		/**
		 * 手机号 -- (属性名称) 
		 */
		public static final String MOBILE = "mobile";
		/**
		 * 密码 -- (属性名称) 
		 */
		public static final String PASSWORD = "password";
		/**
		 * 昵称 -- (属性名称) 
		 */
		public static final String USERNAME = "username";
		/**
		 * 头像 -- (属性名称) 
		 */
		public static final String AVATAR = "avatar";
		/**
		 * 邮箱 -- (属性名称) 
		 */
		public static final String EMAIL = "email";
		/**
		 * 性别[0 女 female; 1 男 male] -- (属性名称) 
		 */
		public static final String SEX = "sex";
		/**
		 * 身份类型[0 普通用户 ordinary; 1 vip vip; 2 svip svip] -- (属性名称) 
		 */
		public static final String IDENTITY_TYPE = "identityType";
		/**
		 * 注册时间 -- (属性名称) 
		 */
		public static final String CREATE_DATE = "createDate";
		/**
		 * 启用状态[0 禁用 no; 1 启用 yes] -- (属性名称) 
		 */
		public static final String ENABLED = "enabled";
	};
	
	/**
	 * 性别 常量类 
	 */
	public static class SexConstant {
		/**
		 * 女   
		 */
		public static final int FEMALE = 0;
		/**
		 * 男   
		 */
		public static final int MALE = 1;
	};
	/**
	 * 身份类型 常量类 
	 */
	public static class IdentityTypeConstant {
		/**
		 * 普通用户   
		 */
		public static final int ORDINARY = 0;
		/**
		 * vip   
		 */
		public static final int VIP = 1;
		/**
		 * svip   
		 */
		public static final int SVIP = 2;
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
	 * 用户标识
	 */
	@Id
	@Column(name = UID)
	private Long uid;
	
	/**
	 * 手机号
	 */
	
	@Column(name = MOBILE)
	private String mobile;
	
	/**
	 * 密码
	 */
	
	@Column(name = PASSWORD)
	private String password;
	
	/**
	 * 昵称
	 */
	
	@Column(name = USERNAME)
	private String username;
	
	/**
	 * 头像
	 */
	
	@Column(name = AVATAR)
	private String avatar;
	
	/**
	 * 邮箱
	 */
	
	@Column(name = EMAIL)
	private String email;
	
	/**
	 * 性别[0 女 female; 1 男 male]
	 */
	
	@Column(name = SEX)
	private Integer sex;
	
	/**
	 * 身份类型[0 普通用户 ordinary; 1 vip vip; 2 svip svip]
	 */
	
	@Column(name = IDENTITY_TYPE)
	private Integer identityType;
	
	/**
	 * 注册时间
	 */
	
	@Column(name = CREATE_DATE)
	private Date createDate;
	
	/**
	 * 启用状态[0 禁用 no; 1 启用 yes]
	 */
	
	@Column(name = ENABLED)
	private Integer enabled;
	



	
	
	/**
	 * 用户标识
	 */
	public Long getUid() {
		return this.uid;	
	}
	
	/**
	 * 用户标识
	 */
	public void setUid(Long uid) {
		this.uid = uid;	
	}
	
	
	
	/**
	 * 手机号
	 */
	public String getMobile() {
		return this.mobile;	
	}
	
	/**
	 * 手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;	
	}
	
	
	
	/**
	 * 密码
	 */
	public String getPassword() {
		return this.password;	
	}
	
	/**
	 * 密码
	 */
	public void setPassword(String password) {
		this.password = password;	
	}
	
	
	
	/**
	 * 昵称
	 */
	public String getUsername() {
		return this.username;	
	}
	
	/**
	 * 昵称
	 */
	public void setUsername(String username) {
		this.username = username;	
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
	 * 邮箱
	 */
	public String getEmail() {
		return this.email;	
	}
	
	/**
	 * 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;	
	}
	
	
	
	/**
	 * 性别[0 女 female; 1 男 male]
	 */
	public Integer getSex() {
		return this.sex;	
	}
	
	/**
	 * 性别[0 女 female; 1 男 male]
	 */
	public void setSex(Integer sex) {
		this.sex = sex;	
	}
	
	
	
	/**
	 * 身份类型[0 普通用户 ordinary; 1 vip vip; 2 svip svip]
	 */
	public Integer getIdentityType() {
		return this.identityType;	
	}
	
	/**
	 * 身份类型[0 普通用户 ordinary; 1 vip vip; 2 svip svip]
	 */
	public void setIdentityType(Integer identityType) {
		this.identityType = identityType;	
	}
	
	
	
	/**
	 * 注册时间
	 */
	public Date getCreateDate() {
		return this.createDate;	
	}
	
	/**
	 * 注册时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;	
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
