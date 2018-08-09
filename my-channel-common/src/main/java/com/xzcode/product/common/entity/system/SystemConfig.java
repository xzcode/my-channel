package com.xzcode.product.common.entity.system;

import java.util.Date;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;

/**
 * 系统配置表 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:03
 */
@Entity
@Table(name = "system_config")
public class SystemConfig {

	/**
	 * 系统配置表 表名
	 */
	public static final String __ = "system_config";

	//列名常量
	
	/**
	 *  主键
	 */
	public static final String UID = "uid";
	
	/**
	 * 键
	 */
	public static final String K = "k";
	
	/**
	 * 值
	 */
	public static final String V = "v";
	
	/**
	 * 创建时间
	 */
	public static final String CREATE_DATE = "create_date";
	
	/**
	 * 备注
	 */
	public static final String REMARK = "remark";
	
	/**
	 * 是否允許用戶配置 [0 不允许 not_allow; 1 允许 allow]
	 */
	public static final String IS_CAN_CONFIG = "is_can_config";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 *  主键 -- (属性名称) 
		 */
		public static final String UID = "uid";
		/**
		 * 键 -- (属性名称) 
		 */
		public static final String K = "k";
		/**
		 * 值 -- (属性名称) 
		 */
		public static final String V = "v";
		/**
		 * 创建时间 -- (属性名称) 
		 */
		public static final String CREATE_DATE = "createDate";
		/**
		 * 备注 -- (属性名称) 
		 */
		public static final String REMARK = "remark";
		/**
		 * 是否允許用戶配置 [0 不允许 not_allow; 1 允许 allow] -- (属性名称) 
		 */
		public static final String IS_CAN_CONFIG = "isCanConfig";
	};
	
	/**
	 * 是否允許用戶配置 常量类 
	 */
	public static class IsCanConfigConstant {
		/**
		 * 不允许   
		 */
		public static final int NOT_ALLOW = 0;
		/**
		 * 允许   
		 */
		public static final int ALLOW = 1;
	};
	


	/**
	 *  主键
	 */
	@Id
	@Column(name = UID)
	private Long uid;
	
	/**
	 * 键
	 */
	
	@Column(name = K)
	private String k;
	
	/**
	 * 值
	 */
	
	@Column(name = V)
	private String v;
	
	/**
	 * 创建时间
	 */
	
	@Column(name = CREATE_DATE)
	private Date createDate;
	
	/**
	 * 备注
	 */
	
	@Column(name = REMARK)
	private String remark;
	
	/**
	 * 是否允許用戶配置 [0 不允许 not_allow; 1 允许 allow]
	 */
	
	@Column(name = IS_CAN_CONFIG)
	private Integer isCanConfig;
	



	
	
	/**
	 *  主键
	 */
	public Long getUid() {
		return this.uid;	
	}
	
	/**
	 *  主键
	 */
	public void setUid(Long uid) {
		this.uid = uid;	
	}
	
	
	
	/**
	 * 键
	 */
	public String getK() {
		return this.k;	
	}
	
	/**
	 * 键
	 */
	public void setK(String k) {
		this.k = k;	
	}
	
	
	
	/**
	 * 值
	 */
	public String getV() {
		return this.v;	
	}
	
	/**
	 * 值
	 */
	public void setV(String v) {
		this.v = v;	
	}
	
	
	
	/**
	 * 创建时间
	 */
	public Date getCreateDate() {
		return this.createDate;	
	}
	
	/**
	 * 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;	
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
	
	
	
	/**
	 * 是否允許用戶配置 [0 不允许 not_allow; 1 允许 allow]
	 */
	public Integer getIsCanConfig() {
		return this.isCanConfig;	
	}
	
	/**
	 * 是否允許用戶配置 [0 不允许 not_allow; 1 允许 allow]
	 */
	public void setIsCanConfig(Integer isCanConfig) {
		this.isCanConfig = isCanConfig;	
	}
	
	
	

}
