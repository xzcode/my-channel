package com.xzcode.product.common.entity.product;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;
import com.xzcode.jdbclink.core.annotations.Entity;
import java.lang.Long;
import java.lang.String;
import java.lang.Integer;

/**
 * 产品分类信息表 实体类
 * 
 * @author JdbcLinkGenerator
 * 2018-07-04 15:25:22
 */
@Entity
@Table(name = "product_category")
public class ProductCategory {

	/**
	 * 产品分类信息表 表名
	 */
	public static final String __ = "product_category";

	//列名常量
	
	/**
	 * 自增主键
	 */
	public static final String UID = "uid";
	
	/**
	 * 分类名称
	 */
	public static final String NAME = "name";
	
	/**
	 * 分类说明
	 */
	public static final String REMARK = "remark";
	
	/**
	 * 首页展示标题
	 */
	public static final String INDEX_SHOW_TITLE = "index_show_title";
	
	/**
	 * 首页展示图片
	 */
	public static final String INDEX_PIC_URL = "index_pic_url";
	
	/**
	 * 分类背景图片
	 */
	public static final String PICTURE_URL = "picture_url";
	
	/**
	 * 排序
	 */
	public static final String SORT = "sort";
	
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
		 * 分类名称 -- (属性名称) 
		 */
		String NAME = "name";
		/**
		 * 分类说明 -- (属性名称) 
		 */
		String REMARK = "remark";
		/**
		 * 首页展示标题 -- (属性名称) 
		 */
		String INDEX_SHOW_TITLE = "indexShowTitle";
		/**
		 * 首页展示图片 -- (属性名称) 
		 */
		String INDEX_PIC_URL = "indexPicUrl";
		/**
		 * 分类背景图片 -- (属性名称) 
		 */
		String PICTURE_URL = "pictureUrl";
		/**
		 * 排序 -- (属性名称) 
		 */
		String SORT = "sort";
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
	 * 分类名称
	 */
	
	@Column(name = NAME)
	private String name;
	
	/**
	 * 分类说明
	 */
	
	@Column(name = REMARK)
	private String remark;
	
	/**
	 * 首页展示标题
	 */
	
	@Column(name = INDEX_SHOW_TITLE)
	private String indexShowTitle;
	
	/**
	 * 首页展示图片
	 */
	
	@Column(name = INDEX_PIC_URL)
	private String indexPicUrl;
	
	/**
	 * 分类背景图片
	 */
	
	@Column(name = PICTURE_URL)
	private String pictureUrl;
	
	/**
	 * 排序
	 */
	
	@Column(name = SORT)
	private Integer sort;
	
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
	public ProductCategory setUid(Long uid) {
		this.uid = uid;
		return this;	
	}
	
	
	
	/**
	 * 分类名称
	 */
	public String getName() {
		return this.name;	
	}
	
	/**
	 * 分类名称
	 */
	public ProductCategory setName(String name) {
		this.name = name;
		return this;	
	}
	
	
	
	/**
	 * 分类说明
	 */
	public String getRemark() {
		return this.remark;	
	}
	
	/**
	 * 分类说明
	 */
	public ProductCategory setRemark(String remark) {
		this.remark = remark;
		return this;	
	}
	
	
	
	/**
	 * 首页展示标题
	 */
	public String getIndexShowTitle() {
		return this.indexShowTitle;	
	}
	
	/**
	 * 首页展示标题
	 */
	public ProductCategory setIndexShowTitle(String indexShowTitle) {
		this.indexShowTitle = indexShowTitle;
		return this;	
	}
	
	
	
	/**
	 * 首页展示图片
	 */
	public String getIndexPicUrl() {
		return this.indexPicUrl;	
	}
	
	/**
	 * 首页展示图片
	 */
	public ProductCategory setIndexPicUrl(String indexPicUrl) {
		this.indexPicUrl = indexPicUrl;
		return this;	
	}
	
	
	
	/**
	 * 分类背景图片
	 */
	public String getPictureUrl() {
		return this.pictureUrl;	
	}
	
	/**
	 * 分类背景图片
	 */
	public ProductCategory setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
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
	public ProductCategory setSort(Integer sort) {
		this.sort = sort;
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
	public ProductCategory setEnabled(Integer enabled) {
		this.enabled = enabled;
		return this;	
	}
	
	
	

}
