package com.xzcode.product.common.entity.banner;

import java.util.Date;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;

/**
 * 轮播图信息表 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:02
 */
@Entity
@Table(name = "banner_info")
public class BannerInfo {

	/**
	 * 轮播图信息表 表名
	 */
	public static final String __ = "banner_info";

	//列名常量
	
	/**
	 * 标识
	 */
	public static final String UID = "uid";
	
	/**
	 * 图片路径
	 */
	public static final String PICTURE_URL = "picture_url";
	
	/**
	 * 链接类型[0 不跳转 common;1 外部链接 out_link; 2 自定义内容 custom ]
	 */
	public static final String LINK_TYPE = "link_type";
	
	/**
	 * 排序，数字越大越靠前
	 */
	public static final String SORT = "sort";
	
	/**
	 * 链接地址
	 */
	public static final String LINK_URL = "link_url";
	
	/**
	 * 自定义富文本内容
	 */
	public static final String CONTENT = "content";
	
	/**
	 * 说明
	 */
	public static final String REMARK = "remark";
	
	/**
	 * 创建时间
	 */
	public static final String CREATE_DATE = "create_date";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 * 标识 -- (属性名称) 
		 */
		public static final String UID = "uid";
		/**
		 * 图片路径 -- (属性名称) 
		 */
		public static final String PICTURE_URL = "pictureUrl";
		/**
		 * 链接类型[0 不跳转 common;1 外部链接 out_link; 2 自定义内容 custom ] -- (属性名称) 
		 */
		public static final String LINK_TYPE = "linkType";
		/**
		 * 排序，数字越大越靠前 -- (属性名称) 
		 */
		public static final String SORT = "sort";
		/**
		 * 链接地址 -- (属性名称) 
		 */
		public static final String LINK_URL = "linkUrl";
		/**
		 * 自定义富文本内容 -- (属性名称) 
		 */
		public static final String CONTENT = "content";
		/**
		 * 说明 -- (属性名称) 
		 */
		public static final String REMARK = "remark";
		/**
		 * 创建时间 -- (属性名称) 
		 */
		public static final String CREATE_DATE = "createDate";
	};
	
	/**
	 * 链接类型 常量类 
	 */
	public static class LinkTypeConstant {
		/**
		 * 不跳转   
		 */
		public static final int COMMON = 0;
		/**
		 * 外部链接   
		 */
		public static final int OUT_LINK = 1;
		/**
		 * 自定义内容   
		 */
		public static final int CUSTOM = 2;
	};
	


	/**
	 * 标识
	 */
	@Id
	@Column(name = UID)
	private Long uid;
	
	/**
	 * 图片路径
	 */
	
	@Column(name = PICTURE_URL)
	private String pictureUrl;
	
	/**
	 * 链接类型[0 不跳转 common;1 外部链接 out_link; 2 自定义内容 custom ]
	 */
	
	@Column(name = LINK_TYPE)
	private Integer linkType;
	
	/**
	 * 排序，数字越大越靠前
	 */
	
	@Column(name = SORT)
	private Integer sort;
	
	/**
	 * 链接地址
	 */
	
	@Column(name = LINK_URL)
	private String linkUrl;
	
	/**
	 * 自定义富文本内容
	 */
	
	@Column(name = CONTENT)
	private String content;
	
	/**
	 * 说明
	 */
	
	@Column(name = REMARK)
	private String remark;
	
	/**
	 * 创建时间
	 */
	
	@Column(name = CREATE_DATE)
	private Date createDate;
	



	
	
	/**
	 * 标识
	 */
	public Long getUid() {
		return this.uid;	
	}
	
	/**
	 * 标识
	 */
	public void setUid(Long uid) {
		this.uid = uid;	
	}
	
	
	
	/**
	 * 图片路径
	 */
	public String getPictureUrl() {
		return this.pictureUrl;	
	}
	
	/**
	 * 图片路径
	 */
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;	
	}
	
	
	
	/**
	 * 链接类型[0 不跳转 common;1 外部链接 out_link; 2 自定义内容 custom ]
	 */
	public Integer getLinkType() {
		return this.linkType;	
	}
	
	/**
	 * 链接类型[0 不跳转 common;1 外部链接 out_link; 2 自定义内容 custom ]
	 */
	public void setLinkType(Integer linkType) {
		this.linkType = linkType;	
	}
	
	
	
	/**
	 * 排序，数字越大越靠前
	 */
	public Integer getSort() {
		return this.sort;	
	}
	
	/**
	 * 排序，数字越大越靠前
	 */
	public void setSort(Integer sort) {
		this.sort = sort;	
	}
	
	
	
	/**
	 * 链接地址
	 */
	public String getLinkUrl() {
		return this.linkUrl;	
	}
	
	/**
	 * 链接地址
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;	
	}
	
	
	
	/**
	 * 自定义富文本内容
	 */
	public String getContent() {
		return this.content;	
	}
	
	/**
	 * 自定义富文本内容
	 */
	public void setContent(String content) {
		this.content = content;	
	}
	
	
	
	/**
	 * 说明
	 */
	public String getRemark() {
		return this.remark;	
	}
	
	/**
	 * 说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;	
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
	
	
	

}
