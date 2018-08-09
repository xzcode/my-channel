package com.xzcode.product.app.service.facade.area;

import com.xzcode.product.app.service.facade.IBaseService;
import com.xzcode.product.common.entity.area.Area;

/**
 * 数据地域信息表 service 接口
 * 
 * @author zai
 * 2018-04-16 17:10:08
 */
public interface IAreaService extends IBaseService<Area>{

	/**
	 * 
	 * @param provinceId
	 * @param cityId
	 * @param areaId
	 * @param separator
	 * @return
	 * 
	 * @author zai
	 * 2018-05-22
	 */
	String getLocationString(Integer provinceId, Integer cityId, Integer areaId, String separator);

}

	


