package com.xzcode.product.common.entity.message;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;
import com.xzcode.jdbclink.core.annotations.Entity;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 留言信息表 实体类
 * 
 * @author JdbcLinkGenerator
 * 2018-07-03 14:20:20
 */
@Entity
@Table(name = "message")
public class Message {

	/**
	 * 留言信息表 表名
	 */
	public static final String __ = "message";

	//列名常量
	
	/**
	 * 自增主键
	 */
	public static final String UID = "uid";
	
	/**
	 * 标题
	 */
	public static final String MOBILE = "mobile";
	
	/**
	 * 用户姓名
	 */
	public static final String USERNAME = "username";
	
	/**
	 * 留言内容
	 */
	public static final String CONTENT = "content";
	
	/**
	 * 创建时间
	 */
	public static final String CREATE_DATE = "create_date";
	
	/**
	 * 备注信息
	 */
	public static final String REMARK = "remark";
	
	/**
	 * 处理日期
	 */
	public static final String HANDLE_DATE = "handle_date";
	
	/**
	 * 处理状态[0 未处理 no; 1 处理中 pending; 2 已处理 yes]
	 */
	public static final String HANDLED = "handled";
	
	
	/**
	 * 属性名称
	 */
	public static interface PropName {
		/**
		 * 自增主键 -- (属性名称) 
		 */
		String UID = "uid";
		/**
		 * 标题 -- (属性名称) 
		 */
		String MOBILE = "mobile";
		/**
		 * 用户姓名 -- (属性名称) 
		 */
		String USERNAME = "username";
		/**
		 * 留言内容 -- (属性名称) 
		 */
		String CONTENT = "content";
		/**
		 * 创建时间 -- (属性名称) 
		 */
		String CREATE_DATE = "createDate";
		/**
		 * 备注信息 -- (属性名称) 
		 */
		String REMARK = "remark";
		/**
		 * 处理日期 -- (属性名称) 
		 */
		String HANDLE_DATE = "handleDate";
		/**
		 * 处理状态[0 未处理 no; 1 处理中 pending; 2 已处理 yes] -- (属性名称) 
		 */
		String HANDLED = "handled";
	};
	
		/**
		 * 处理状态 常量类 
		 */
		public static interface HandledConstant {
			/**
			 * 未处理   
			 */
			int NO = 0;
			/**
			 * 处理中   
			 */
			int PENDING = 1;
			/**
			 * 已处理   
			 */
			int YES = 2;
		};
	


	/**
	 * 自增主键
	 */
	@Id
	@Column(name = UID)
	private Long uid;
	
	/**
	 * 标题
	 */
	
	@Column(name = MOBILE)
	private String mobile;
	
	/**
	 * 用户姓名
	 */
	
	@Column(name = USERNAME)
	private String username;
	
	/**
	 * 留言内容
	 */
	
	@Column(name = CONTENT)
	private String content;
	
	/**
	 * 创建时间
	 */
	
	@Column(name = CREATE_DATE)
	private Date createDate;
	
	/**
	 * 备注信息
	 */
	
	@Column(name = REMARK)
	private String remark;
	
	/**
	 * 处理日期
	 */
	
	@Column(name = HANDLE_DATE)
	private Date handleDate;
	
	/**
	 * 处理状态[0 未处理 no; 1 处理中 pending; 2 已处理 yes]
	 */
	
	@Column(name = HANDLED)
	private Integer handled;
	



	
	
	/**
	 * 自增主键
	 */
	public Long getUid() {
		return this.uid;	
	}
	
	/**
	 * 自增主键
	 */
	public Message setUid(Long uid) {
		this.uid = uid;
		return this;	
	}
	
	
	
	/**
	 * 标题
	 */
	public String getMobile() {
		return this.mobile;	
	}
	
	/**
	 * 标题
	 */
	public Message setMobile(String mobile) {
		this.mobile = mobile;
		return this;	
	}
	
	
	
	/**
	 * 用户姓名
	 */
	public String getUsername() {
		return this.username;	
	}
	
	/**
	 * 用户姓名
	 */
	public Message setUsername(String username) {
		this.username = username;
		return this;	
	}
	
	
	
	/**
	 * 留言内容
	 */
	public String getContent() {
		return this.content;	
	}
	
	/**
	 * 留言内容
	 */
	public Message setContent(String content) {
		this.content = content;
		return this;	
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
	public Message setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;	
	}
	
	
	
	/**
	 * 备注信息
	 */
	public String getRemark() {
		return this.remark;	
	}
	
	/**
	 * 备注信息
	 */
	public Message setRemark(String remark) {
		this.remark = remark;
		return this;	
	}
	
	
	
	/**
	 * 处理日期
	 */
	public Date getHandleDate() {
		return this.handleDate;	
	}
	
	/**
	 * 处理日期
	 */
	public Message setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
		return this;	
	}
	
	
	
	/**
	 * 处理状态[0 未处理 no; 1 处理中 pending; 2 已处理 yes]
	 */
	public Integer getHandled() {
		return this.handled;	
	}
	
	/**
	 * 处理状态[0 未处理 no; 1 处理中 pending; 2 已处理 yes]
	 */
	public Message setHandled(Integer handled) {
		this.handled = handled;
		return this;	
	}
	
	
	

}
