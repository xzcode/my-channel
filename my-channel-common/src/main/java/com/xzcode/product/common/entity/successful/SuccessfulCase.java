package com.xzcode.product.common.entity.successful;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;
import com.xzcode.jdbclink.core.annotations.Entity;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 成功案例信息表 实体类
 * 
 * @author JdbcLinkGenerator
 * 2018-07-04 23:59:34
 */
@Entity
@Table(name = "successful_case")
public class SuccessfulCase {

	/**
	 * 成功案例信息表 表名
	 */
	public static final String __ = "successful_case";

	//列名常量
	
	/**
	 * 自增主键
	 */
	public static final String UID = "uid";
	
	/**
	 * 发布管理员
	 */
	public static final String ADMIN_ID = "admin_id";
	
	/**
	 * 标题
	 */
	public static final String TITLE = "title";
	
	/**
	 * 简介
	 */
	public static final String INTRO = "intro";
	
	/**
	 * 配图
	 */
	public static final String COVER_URL = "cover_url";
	
	/**
	 * 自定义富文本内容
	 */
	public static final String CONTENT = "content";
	
	/**
	 * 排序
	 */
	public static final String SORT = "sort";
	
	/**
	 * 查看数
	 */
	public static final String READ_NUM = "read_num";
	
	/**
	 * 热门参数
	 */
	public static final String HOT_NUM = "hot_num";
	
	/**
	 * 创建时间
	 */
	public static final String CREATE_DATE = "create_date";
	
	/**
	 * SEO自定义标题
	 */
	public static final String SEO_TITLE = "seo_title";
	
	/**
	 * SEO自定义关键字
	 */
	public static final String SEO_KEYWORDS = "seo_keywords";
	
	/**
	 * SEO自定义说明
	 */
	public static final String SEO_DESCRIPTION = "seo_description";
	
	/**
	 * 启用状态[0 禁用 no; 1 启用 yes]
	 */
	public static final String ENABLED = "enabled";
	
	
	/**
	 * 属性名称
	 */
	public static interface PropName {
		/**
		 * 自增主键 -- (属性名称) 
		 */
		String UID = "uid";
		/**
		 * 发布管理员 -- (属性名称) 
		 */
		String ADMIN_ID = "adminId";
		/**
		 * 标题 -- (属性名称) 
		 */
		String TITLE = "title";
		/**
		 * 简介 -- (属性名称) 
		 */
		String INTRO = "intro";
		/**
		 * 配图 -- (属性名称) 
		 */
		String COVER_URL = "coverUrl";
		/**
		 * 自定义富文本内容 -- (属性名称) 
		 */
		String CONTENT = "content";
		/**
		 * 排序 -- (属性名称) 
		 */
		String SORT = "sort";
		/**
		 * 查看数 -- (属性名称) 
		 */
		String READ_NUM = "readNum";
		/**
		 * 热门参数 -- (属性名称) 
		 */
		String HOT_NUM = "hotNum";
		/**
		 * 创建时间 -- (属性名称) 
		 */
		String CREATE_DATE = "createDate";
		/**
		 * SEO自定义标题 -- (属性名称) 
		 */
		String SEO_TITLE = "seoTitle";
		/**
		 * SEO自定义关键字 -- (属性名称) 
		 */
		String SEO_KEYWORDS = "seoKeywords";
		/**
		 * SEO自定义说明 -- (属性名称) 
		 */
		String SEO_DESCRIPTION = "seoDescription";
		/**
		 * 启用状态[0 禁用 no; 1 启用 yes] -- (属性名称) 
		 */
		String ENABLED = "enabled";
	};
	
		/**
		 * 启用状态 常量类 
		 */
		public static interface EnabledConstant {
			/**
			 * 禁用   
			 */
			int NO = 0;
			/**
			 * 启用   
			 */
			int YES = 1;
		};
	


	/**
	 * 自增主键
	 */
	@Id
	@Column(name = UID)
	private Long uid;
	
	/**
	 * 发布管理员
	 */
	
	@Column(name = ADMIN_ID)
	private Long adminId;
	
	/**
	 * 标题
	 */
	
	@Column(name = TITLE)
	private String title;
	
	/**
	 * 简介
	 */
	
	@Column(name = INTRO)
	private String intro;
	
	/**
	 * 配图
	 */
	
	@Column(name = COVER_URL)
	private String coverUrl;
	
	/**
	 * 自定义富文本内容
	 */
	
	@Column(name = CONTENT)
	private String content;
	
	/**
	 * 排序
	 */
	
	@Column(name = SORT)
	private Integer sort;
	
	/**
	 * 查看数
	 */
	
	@Column(name = READ_NUM)
	private Integer readNum;
	
	/**
	 * 热门参数
	 */
	
	@Column(name = HOT_NUM)
	private Integer hotNum;
	
	/**
	 * 创建时间
	 */
	
	@Column(name = CREATE_DATE)
	private Date createDate;
	
	/**
	 * SEO自定义标题
	 */
	
	@Column(name = SEO_TITLE)
	private String seoTitle;
	
	/**
	 * SEO自定义关键字
	 */
	
	@Column(name = SEO_KEYWORDS)
	private String seoKeywords;
	
	/**
	 * SEO自定义说明
	 */
	
	@Column(name = SEO_DESCRIPTION)
	private String seoDescription;
	
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
	public SuccessfulCase setUid(Long uid) {
		this.uid = uid;
		return this;	
	}
	
	
	
	/**
	 * 发布管理员
	 */
	public Long getAdminId() {
		return this.adminId;	
	}
	
	/**
	 * 发布管理员
	 */
	public SuccessfulCase setAdminId(Long adminId) {
		this.adminId = adminId;
		return this;	
	}
	
	
	
	/**
	 * 标题
	 */
	public String getTitle() {
		return this.title;	
	}
	
	/**
	 * 标题
	 */
	public SuccessfulCase setTitle(String title) {
		this.title = title;
		return this;	
	}
	
	
	
	/**
	 * 简介
	 */
	public String getIntro() {
		return this.intro;	
	}
	
	/**
	 * 简介
	 */
	public SuccessfulCase setIntro(String intro) {
		this.intro = intro;
		return this;	
	}
	
	
	
	/**
	 * 配图
	 */
	public String getCoverUrl() {
		return this.coverUrl;	
	}
	
	/**
	 * 配图
	 */
	public SuccessfulCase setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
		return this;	
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
	public SuccessfulCase setContent(String content) {
		this.content = content;
		return this;	
	}
	
	
	
	/**
	 * 排序
	 */
	public Integer getSort() {
		return this.sort;	
	}
	
	/**
	 * 排序
	 */
	public SuccessfulCase setSort(Integer sort) {
		this.sort = sort;
		return this;	
	}
	
	
	
	/**
	 * 查看数
	 */
	public Integer getReadNum() {
		return this.readNum;	
	}
	
	/**
	 * 查看数
	 */
	public SuccessfulCase setReadNum(Integer readNum) {
		this.readNum = readNum;
		return this;	
	}
	
	
	
	/**
	 * 热门参数
	 */
	public Integer getHotNum() {
		return this.hotNum;	
	}
	
	/**
	 * 热门参数
	 */
	public SuccessfulCase setHotNum(Integer hotNum) {
		this.hotNum = hotNum;
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
	public SuccessfulCase setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;	
	}
	
	
	
	/**
	 * SEO自定义标题
	 */
	public String getSeoTitle() {
		return this.seoTitle;	
	}
	
	/**
	 * SEO自定义标题
	 */
	public SuccessfulCase setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
		return this;	
	}
	
	
	
	/**
	 * SEO自定义关键字
	 */
	public String getSeoKeywords() {
		return this.seoKeywords;	
	}
	
	/**
	 * SEO自定义关键字
	 */
	public SuccessfulCase setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
		return this;	
	}
	
	
	
	/**
	 * SEO自定义说明
	 */
	public String getSeoDescription() {
		return this.seoDescription;	
	}
	
	/**
	 * SEO自定义说明
	 */
	public SuccessfulCase setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
		return this;	
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
	public SuccessfulCase setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;	
	}
	
	
	

}
