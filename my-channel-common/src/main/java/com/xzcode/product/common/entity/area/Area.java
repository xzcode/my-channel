package com.xzcode.product.common.entity.area;

import com.xzcode.jdbclink.core.annotations.Column;
import com.xzcode.jdbclink.core.annotations.Entity;
import com.xzcode.jdbclink.core.annotations.Id;
import com.xzcode.jdbclink.core.annotations.Table;


/**
 * 数据地域信息表 实体类
 * 
 * @author zai
 * 2018-04-16 16:59:02
 */
@Entity
@Table(name = "area")
public class Area {

	/**
	 * 数据地域信息表 表名
	 */
	public static final String __ = "area";

	//列名常量
	
	/**
	 * 
	 */
	public static final String UID = "uid";
	
	/**
	 * 父级
	 */
	public static final String AREA_ID = "area_id";
	
	/**
	 * 名称
	 */
	public static final String NAME = "name";
	
	/**
	 * 简称
	 */
	public static final String SHORTNAME = "shortname";
	
	/**
	 * 经度
	 */
	public static final String LONGITUDE = "longitude";
	
	/**
	 * 纬度
	 */
	public static final String LATITUDE = "latitude";
	
	/**
	 * 级别
	 */
	public static final String LAYER = "layer";
	
	/**
	 * 排序
	 */
	public static final String SORT = "sort";
	
	/**
	 * 状态1有效
	 */
	public static final String STATUS = "status";
	
	
	/**
	 * 属性名称
	 */
	public static class PropName {
		/**
		 *  -- (属性名称) 
		 */
		public static final String UID = "uid";
		/**
		 * 父级 -- (属性名称) 
		 */
		public static final String AREA_ID = "areaId";
		/**
		 * 名称 -- (属性名称) 
		 */
		public static final String NAME = "name";
		/**
		 * 简称 -- (属性名称) 
		 */
		public static final String SHORTNAME = "shortname";
		/**
		 * 经度 -- (属性名称) 
		 */
		public static final String LONGITUDE = "longitude";
		/**
		 * 纬度 -- (属性名称) 
		 */
		public static final String LATITUDE = "latitude";
		/**
		 * 级别 -- (属性名称) 
		 */
		public static final String LAYER = "layer";
		/**
		 * 排序 -- (属性名称) 
		 */
		public static final String SORT = "sort";
		/**
		 * 状态1有效 -- (属性名称) 
		 */
		public static final String STATUS = "status";
	};
	
	


	/**
	 * 
	 */
	@Id
	@Column(name = UID)
	private Integer uid;
	
	/**
	 * 父级
	 */
	
	@Column(name = AREA_ID)
	private Integer areaId;
	
	/**
	 * 名称
	 */
	
	@Column(name = NAME)
	private String name;
	
	/**
	 * 简称
	 */
	
	@Column(name = SHORTNAME)
	private String shortname;
	
	/**
	 * 经度
	 */
	
	@Column(name = LONGITUDE)
	private String longitude;
	
	/**
	 * 纬度
	 */
	
	@Column(name = LATITUDE)
	private String latitude;
	
	/**
	 * 级别
	 */
	
	@Column(name = LAYER)
	private Integer layer;
	
	/**
	 * 排序
	 */
	
	@Column(name = SORT)
	private Integer sort;
	
	/**
	 * 状态1有效
	 */
	
	@Column(name = STATUS)
	private Integer status;
	



	
	
	/**
	 * 
	 */
	public Integer getUid() {
		return this.uid;	
	}
	
	/**
	 * 
	 */
	public void setUid(Integer uid) {
		this.uid = uid;	
	}
	
	
	
	/**
	 * 父级
	 */
	public Integer getAreaId() {
		return this.areaId;	
	}
	
	/**
	 * 父级
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;	
	}
	
	
	
	/**
	 * 名称
	 */
	public String getName() {
		return this.name;	
	}
	
	/**
	 * 名称
	 */
	public void setName(String name) {
		this.name = name;	
	}
	
	
	
	/**
	 * 简称
	 */
	public String getShortname() {
		return this.shortname;	
	}
	
	/**
	 * 简称
	 */
	public void setShortname(String shortname) {
		this.shortname = shortname;	
	}
	
	
	
	/**
	 * 经度
	 */
	public String getLongitude() {
		return this.longitude;	
	}
	
	/**
	 * 经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;	
	}
	
	
	
	/**
	 * 纬度
	 */
	public String getLatitude() {
		return this.latitude;	
	}
	
	/**
	 * 纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;	
	}
	
	
	
	/**
	 * 级别
	 */
	public Integer getLayer() {
		return this.layer;	
	}
	
	/**
	 * 级别
	 */
	public void setLayer(Integer layer) {
		this.layer = layer;	
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
	public void setSort(Integer sort) {
		this.sort = sort;	
	}
	
	
	
	/**
	 * 状态1有效
	 */
	public Integer getStatus() {
		return this.status;	
	}
	
	/**
	 * 状态1有效
	 */
	public void setStatus(Integer status) {
		this.status = status;	
	}
	
	
	

}
