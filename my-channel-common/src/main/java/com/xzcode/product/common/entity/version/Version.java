package com.xzcode.product.common.entity.version;

import java.util.Date;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;

/**
 * 版本信息表 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:03
 */
@Entity
@Table(name = "version")
public class Version {

	/**
	 * 版本信息表 表名
	 */
	public static final String __ = "version";

	//列名常量
	
	/**
	 * 
	 */
	public static final String UID = "uid";
	
	/**
	 * 版本号
	 */
	public static final String VERSION = "version";
	
	/**
	 * 版本序号，自增
	 */
	public static final String VERSION_CODE = "version_code";
	
	/**
	 * 下载app安装文件的url
	 */
	public static final String URL = "url";
	
	/**
	 * 更新内容说明
	 */
	public static final String CONTENT = "content";
	
	/**
	 * 设备类型
	 */
	public static final String DEVICE_TYPE = "device_type";
	
	/**
	 * 创建时间
	 */
	public static final String CREATE_DATE = "create_date";
	
	/**
	 * app安装文件的相对路径
	 */
	public static final String APP_PATH = "app_path";
	
	/**
	 * 审核状态[0 正在审核 in_review; 1 审核通过 passed]
	 */
	public static final String CHECK_STATE = "check_state";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 *  -- (属性名称) 
		 */
		public static final String UID = "uid";
		/**
		 * 版本号 -- (属性名称) 
		 */
		public static final String VERSION = "version";
		/**
		 * 版本序号，自增 -- (属性名称) 
		 */
		public static final String VERSION_CODE = "versionCode";
		/**
		 * 下载app安装文件的url -- (属性名称) 
		 */
		public static final String URL = "url";
		/**
		 * 更新内容说明 -- (属性名称) 
		 */
		public static final String CONTENT = "content";
		/**
		 * 设备类型 -- (属性名称) 
		 */
		public static final String DEVICE_TYPE = "deviceType";
		/**
		 * 创建时间 -- (属性名称) 
		 */
		public static final String CREATE_DATE = "createDate";
		/**
		 * app安装文件的相对路径 -- (属性名称) 
		 */
		public static final String APP_PATH = "appPath";
		/**
		 * 审核状态[0 正在审核 in_review; 1 审核通过 passed] -- (属性名称) 
		 */
		public static final String CHECK_STATE = "checkState";
	};
	
	/**
	 * 审核状态 常量类 
	 */
	public static class CheckStateConstant {
		/**
		 * 正在审核   
		 */
		public static final int IN_REVIEW = 0;
		/**
		 * 审核通过   
		 */
		public static final int PASSED = 1;
	};
	


	/**
	 * 
	 */
	@Id
	@Column(name = UID)
	private Long uid;
	
	/**
	 * 版本号
	 */
	
	@Column(name = VERSION)
	private String version;
	
	/**
	 * 版本序号，自增
	 */
	
	@Column(name = VERSION_CODE)
	private Integer versionCode;
	
	/**
	 * 下载app安装文件的url
	 */
	
	@Column(name = URL)
	private String url;
	
	/**
	 * 更新内容说明
	 */
	
	@Column(name = CONTENT)
	private String content;
	
	/**
	 * 设备类型
	 */
	
	@Column(name = DEVICE_TYPE)
	private String deviceType;
	
	/**
	 * 创建时间
	 */
	
	@Column(name = CREATE_DATE)
	private Date createDate;
	
	/**
	 * app安装文件的相对路径
	 */
	
	@Column(name = APP_PATH)
	private String appPath;
	
	/**
	 * 审核状态[0 正在审核 in_review; 1 审核通过 passed]
	 */
	
	@Column(name = CHECK_STATE)
	private Integer checkState;
	



	
	
	/**
	 * 
	 */
	public Long getUid() {
		return this.uid;	
	}
	
	/**
	 * 
	 */
	public void setUid(Long uid) {
		this.uid = uid;	
	}
	
	
	
	/**
	 * 版本号
	 */
	public String getVersion() {
		return this.version;	
	}
	
	/**
	 * 版本号
	 */
	public void setVersion(String version) {
		this.version = version;	
	}
	
	
	
	/**
	 * 版本序号，自增
	 */
	public Integer getVersionCode() {
		return this.versionCode;	
	}
	
	/**
	 * 版本序号，自增
	 */
	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;	
	}
	
	
	
	/**
	 * 下载app安装文件的url
	 */
	public String getUrl() {
		return this.url;	
	}
	
	/**
	 * 下载app安装文件的url
	 */
	public void setUrl(String url) {
		this.url = url;	
	}
	
	
	
	/**
	 * 更新内容说明
	 */
	public String getContent() {
		return this.content;	
	}
	
	/**
	 * 更新内容说明
	 */
	public void setContent(String content) {
		this.content = content;	
	}
	
	
	
	/**
	 * 设备类型
	 */
	public String getDeviceType() {
		return this.deviceType;	
	}
	
	/**
	 * 设备类型
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;	
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
	 * app安装文件的相对路径
	 */
	public String getAppPath() {
		return this.appPath;	
	}
	
	/**
	 * app安装文件的相对路径
	 */
	public void setAppPath(String appPath) {
		this.appPath = appPath;	
	}
	
	
	
	/**
	 * 审核状态[0 正在审核 in_review; 1 审核通过 passed]
	 */
	public Integer getCheckState() {
		return this.checkState;	
	}
	
	/**
	 * 审核状态[0 正在审核 in_review; 1 审核通过 passed]
	 */
	public void setCheckState(Integer checkState) {
		this.checkState = checkState;	
	}
	
	
	

}
