package com.xzcode.product.common.entity.product;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;
import com.xzcode.jdbclink.core.annotations.Entity;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

/**
 * 产品信息表 实体类
 * 
 * @author JdbcLinkGenerator
 * 2018-07-04 23:59:34
 */
@Entity
@Table(name = "product")
public class Product {

	/**
	 * 产品信息表 表名
	 */
	public static final String __ = "product";

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
	 * 产品分类
	 */
	public static final String CATEGORY_ID = "category_id";
	
	/**
	 * 产品分类名称
	 */
	public static final String CATEGORY_NAME = "category_name";
	
	/**
	 * 列表标题
	 */
	public static final String COVER_TITLE = "cover_title";
	
	/**
	 * 列表配图
	 */
	public static final String COVER_URL = "cover_url";
	
	/**
	 * 列表简介
	 */
	public static final String COVER_INTRO = "cover_intro";
	
	/**
	 * 详情背景图
	 */
	public static final String DETAIL_BG_URL = "detail_bg_url";
	
	/**
	 * 详情展示图
	 */
	public static final String DETAIL_SHOW_URL = "detail_show_url";
	
	/**
	 * 详情标题
	 */
	public static final String DETAIL_TITLE = "detail_title";
	
	/**
	 * 产品介绍
	 */
	public static final String DETAIL_INTRO_TEXT = "detail_intro_text";
	
	/**
	 * 产品特性
	 */
	public static final String DETAIL_PROPS_TEXT = "detail_props_text";
	
	/**
	 * 产品参数
	 */
	public static final String DETAIL_PARAMS_TEXT = "detail_params_text";
	
	/**
	 * 产品配件
	 */
	public static final String DETAIL_PARTS_TEXT = "detail_parts_text";
	
	/**
	 * 排序
	 */
	public static final String SORT = "sort";
	
	/**
	 * 查看数
	 */
	public static final String READ_NUM = "read_num";
	
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
		 * 产品分类 -- (属性名称) 
		 */
		String CATEGORY_ID = "categoryId";
		/**
		 * 产品分类名称 -- (属性名称) 
		 */
		String CATEGORY_NAME = "categoryName";
		/**
		 * 列表标题 -- (属性名称) 
		 */
		String COVER_TITLE = "coverTitle";
		/**
		 * 列表配图 -- (属性名称) 
		 */
		String COVER_URL = "coverUrl";
		/**
		 * 列表简介 -- (属性名称) 
		 */
		String COVER_INTRO = "coverIntro";
		/**
		 * 详情背景图 -- (属性名称) 
		 */
		String DETAIL_BG_URL = "detailBgUrl";
		/**
		 * 详情展示图 -- (属性名称) 
		 */
		String DETAIL_SHOW_URL = "detailShowUrl";
		/**
		 * 详情标题 -- (属性名称) 
		 */
		String DETAIL_TITLE = "detailTitle";
		/**
		 * 产品介绍 -- (属性名称) 
		 */
		String DETAIL_INTRO_TEXT = "detailIntroText";
		/**
		 * 产品特性 -- (属性名称) 
		 */
		String DETAIL_PROPS_TEXT = "detailPropsText";
		/**
		 * 产品参数 -- (属性名称) 
		 */
		String DETAIL_PARAMS_TEXT = "detailParamsText";
		/**
		 * 产品配件 -- (属性名称) 
		 */
		String DETAIL_PARTS_TEXT = "detailPartsText";
		/**
		 * 排序 -- (属性名称) 
		 */
		String SORT = "sort";
		/**
		 * 查看数 -- (属性名称) 
		 */
		String READ_NUM = "readNum";
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
	 * 产品分类
	 */
	
	@Column(name = CATEGORY_ID)
	private Long categoryId;
	
	/**
	 * 产品分类名称
	 */
	
	@Column(name = CATEGORY_NAME)
	private String categoryName;
	
	/**
	 * 列表标题
	 */
	
	@Column(name = COVER_TITLE)
	private String coverTitle;
	
	/**
	 * 列表配图
	 */
	
	@Column(name = COVER_URL)
	private String coverUrl;
	
	/**
	 * 列表简介
	 */
	
	@Column(name = COVER_INTRO)
	private String coverIntro;
	
	/**
	 * 详情背景图
	 */
	
	@Column(name = DETAIL_BG_URL)
	private String detailBgUrl;
	
	/**
	 * 详情展示图
	 */
	
	@Column(name = DETAIL_SHOW_URL)
	private String detailShowUrl;
	
	/**
	 * 详情标题
	 */
	
	@Column(name = DETAIL_TITLE)
	private String detailTitle;
	
	/**
	 * 产品介绍
	 */
	
	@Column(name = DETAIL_INTRO_TEXT)
	private String detailIntroText;
	
	/**
	 * 产品特性
	 */
	
	@Column(name = DETAIL_PROPS_TEXT)
	private String detailPropsText;
	
	/**
	 * 产品参数
	 */
	
	@Column(name = DETAIL_PARAMS_TEXT)
	private String detailParamsText;
	
	/**
	 * 产品配件
	 */
	
	@Column(name = DETAIL_PARTS_TEXT)
	private String detailPartsText;
	
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
	public Product setUid(Long uid) {
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
	public Product setAdminId(Long adminId) {
		this.adminId = adminId;
		return this;	
	}
	
	
	
	/**
	 * 产品分类
	 */
	public Long getCategoryId() {
		return this.categoryId;	
	}
	
	/**
	 * 产品分类
	 */
	public Product setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
		return this;	
	}
	
	
	
	/**
	 * 产品分类名称
	 */
	public String getCategoryName() {
		return this.categoryName;	
	}
	
	/**
	 * 产品分类名称
	 */
	public Product setCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;	
	}
	
	
	
	/**
	 * 列表标题
	 */
	public String getCoverTitle() {
		return this.coverTitle;	
	}
	
	/**
	 * 列表标题
	 */
	public Product setCoverTitle(String coverTitle) {
		this.coverTitle = coverTitle;
		return this;	
	}
	
	
	
	/**
	 * 列表配图
	 */
	public String getCoverUrl() {
		return this.coverUrl;	
	}
	
	/**
	 * 列表配图
	 */
	public Product setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
		return this;	
	}
	
	
	
	/**
	 * 列表简介
	 */
	public String getCoverIntro() {
		return this.coverIntro;	
	}
	
	/**
	 * 列表简介
	 */
	public Product setCoverIntro(String coverIntro) {
		this.coverIntro = coverIntro;
		return this;	
	}
	
	
	
	/**
	 * 详情背景图
	 */
	public String getDetailBgUrl() {
		return this.detailBgUrl;	
	}
	
	/**
	 * 详情背景图
	 */
	public Product setDetailBgUrl(String detailBgUrl) {
		this.detailBgUrl = detailBgUrl;
		return this;	
	}
	
	
	
	/**
	 * 详情展示图
	 */
	public String getDetailShowUrl() {
		return this.detailShowUrl;	
	}
	
	/**
	 * 详情展示图
	 */
	public Product setDetailShowUrl(String detailShowUrl) {
		this.detailShowUrl = detailShowUrl;
		return this;	
	}
	
	
	
	/**
	 * 详情标题
	 */
	public String getDetailTitle() {
		return this.detailTitle;	
	}
	
	/**
	 * 详情标题
	 */
	public Product setDetailTitle(String detailTitle) {
		this.detailTitle = detailTitle;
		return this;	
	}
	
	
	
	/**
	 * 产品介绍
	 */
	public String getDetailIntroText() {
		return this.detailIntroText;	
	}
	
	/**
	 * 产品介绍
	 */
	public Product setDetailIntroText(String detailIntroText) {
		this.detailIntroText = detailIntroText;
		return this;	
	}
	
	
	
	/**
	 * 产品特性
	 */
	public String getDetailPropsText() {
		return this.detailPropsText;	
	}
	
	/**
	 * 产品特性
	 */
	public Product setDetailPropsText(String detailPropsText) {
		this.detailPropsText = detailPropsText;
		return this;	
	}
	
	
	
	/**
	 * 产品参数
	 */
	public String getDetailParamsText() {
		return this.detailParamsText;	
	}
	
	/**
	 * 产品参数
	 */
	public Product setDetailParamsText(String detailParamsText) {
		this.detailParamsText = detailParamsText;
		return this;	
	}
	
	
	
	/**
	 * 产品配件
	 */
	public String getDetailPartsText() {
		return this.detailPartsText;	
	}
	
	/**
	 * 产品配件
	 */
	public Product setDetailPartsText(String detailPartsText) {
		this.detailPartsText = detailPartsText;
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
	public Product setSort(Integer sort) {
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
	public Product setReadNum(Integer readNum) {
		this.readNum = readNum;
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
	public Product setCreateDate(Date createDate) {
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
	public Product setSeoTitle(String seoTitle) {
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
	public Product setSeoKeywords(String seoKeywords) {
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
	public Product setSeoDescription(String seoDescription) {
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
	public Product setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;	
	}
	
	
	

}
