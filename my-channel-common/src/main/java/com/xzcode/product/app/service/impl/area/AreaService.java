package com.xzcode.product.app.service.impl.area;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.area.AreaMapper;
import com.xzcode.product.app.service.facade.area.IAreaService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.area.Area;




/**
 * 数据地域信息表 service
 * 
 * @author zai & code generator
 * 2018-04-16 16:59:02
 */
@Service
public class AreaService extends BaseService<Area> implements IAreaService{
	
	@Autowired
	private AreaMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}
	
	@Override
	public String getLocationString(Integer provinceId, Integer cityId, Integer areaId, String separator) {
		if (separator == null) {
			separator = "";
		}
		Area province = jdbcLink.select(provinceId, Area.class);
		Area city = jdbcLink.select(cityId, Area.class);
		Area area = jdbcLink.select(areaId, Area.class);
		
		return province.getName() + separator + city.getName() + separator + area.getName();
	}

}

	


