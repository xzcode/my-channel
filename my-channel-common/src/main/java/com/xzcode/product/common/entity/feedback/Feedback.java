package com.xzcode.product.common.entity.feedback;

import java.util.Date;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;

/**
 * 用户反馈信息表 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:02
 */
@Entity
@Table(name = "feedback")
public class Feedback {

	/**
	 * 用户反馈信息表 表名
	 */
	public static final String __ = "feedback";

	//列名常量
	
	/**
	 * 唯一id
	 */
	public static final String UID = "uid";
	
	/**
	 * 用户标识
	 */
	public static final String USER_ID = "user_id";
	
	/**
	 * 反馈内容
	 */
	public static final String CONTENT = "content";
	
	/**
	 * 回复
	 */
	public static final String REPLY = "reply";
	
	/**
	 * 创建日期
	 */
	public static final String CREATE_DATE = "create_date";
	
	/**
	 * 回复日期
	 */
	public static final String REPLY_DATE = "reply_date";
	
	/**
	 * 回复人
	 */
	public static final String REPLY_BY = "reply_by";
	
	/**
	 * 备注
	 */
	public static final String REMARK = "remark";
	
	/**
	 * 回复状态[0 未回复 unanswered; 1 已回复 replied]
	 */
	public static final String STATUS = "status";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 * 唯一id -- (属性名称) 
		 */
		public static final String UID = "uid";
		/**
		 * 用户标识 -- (属性名称) 
		 */
		public static final String USER_ID = "userId";
		/**
		 * 反馈内容 -- (属性名称) 
		 */
		public static final String CONTENT = "content";
		/**
		 * 回复 -- (属性名称) 
		 */
		public static final String REPLY = "reply";
		/**
		 * 创建日期 -- (属性名称) 
		 */
		public static final String CREATE_DATE = "createDate";
		/**
		 * 回复日期 -- (属性名称) 
		 */
		public static final String REPLY_DATE = "replyDate";
		/**
		 * 回复人 -- (属性名称) 
		 */
		public static final String REPLY_BY = "replyBy";
		/**
		 * 备注 -- (属性名称) 
		 */
		public static final String REMARK = "remark";
		/**
		 * 回复状态[0 未回复 unanswered; 1 已回复 replied] -- (属性名称) 
		 */
		public static final String STATUS = "status";
	};
	
	/**
	 * 回复状态 常量类 
	 */
	public static class StatusConstant {
		/**
		 * 未回复   
		 */
		public static final int UNANSWERED = 0;
		/**
		 * 已回复   
		 */
		public static final int REPLIED = 1;
	};
	


	/**
	 * 唯一id
	 */
	@Id
	@Column(name = UID)
	private Long uid;
	
	/**
	 * 用户标识
	 */
	
	@Column(name = USER_ID)
	private Long userId;
	
	/**
	 * 反馈内容
	 */
	
	@Column(name = CONTENT)
	private String content;
	
	/**
	 * 回复
	 */
	
	@Column(name = REPLY)
	private String reply;
	
	/**
	 * 创建日期
	 */
	
	@Column(name = CREATE_DATE)
	private Date createDate;
	
	/**
	 * 回复日期
	 */
	
	@Column(name = REPLY_DATE)
	private Date replyDate;
	
	/**
	 * 回复人
	 */
	
	@Column(name = REPLY_BY)
	private Long replyBy;
	
	/**
	 * 备注
	 */
	
	@Column(name = REMARK)
	private String remark;
	
	/**
	 * 回复状态[0 未回复 unanswered; 1 已回复 replied]
	 */
	
	@Column(name = STATUS)
	private Integer status;
	



	
	
	/**
	 * 唯一id
	 */
	public Long getUid() {
		return this.uid;	
	}
	
	/**
	 * 唯一id
	 */
	public void setUid(Long uid) {
		this.uid = uid;	
	}
	
	
	
	/**
	 * 用户标识
	 */
	public Long getUserId() {
		return this.userId;	
	}
	
	/**
	 * 用户标识
	 */
	public void setUserId(Long userId) {
		this.userId = userId;	
	}
	
	
	
	/**
	 * 反馈内容
	 */
	public String getContent() {
		return this.content;	
	}
	
	/**
	 * 反馈内容
	 */
	public void setContent(String content) {
		this.content = content;	
	}
	
	
	
	/**
	 * 回复
	 */
	public String getReply() {
		return this.reply;	
	}
	
	/**
	 * 回复
	 */
	public void setReply(String reply) {
		this.reply = reply;	
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
	 * 回复日期
	 */
	public Date getReplyDate() {
		return this.replyDate;	
	}
	
	/**
	 * 回复日期
	 */
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;	
	}
	
	
	
	/**
	 * 回复人
	 */
	public Long getReplyBy() {
		return this.replyBy;	
	}
	
	/**
	 * 回复人
	 */
	public void setReplyBy(Long replyBy) {
		this.replyBy = replyBy;	
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
	 * 回复状态[0 未回复 unanswered; 1 已回复 replied]
	 */
	public Integer getStatus() {
		return this.status;	
	}
	
	/**
	 * 回复状态[0 未回复 unanswered; 1 已回复 replied]
	 */
	public void setStatus(Integer status) {
		this.status = status;	
	}
	
	
	

}
