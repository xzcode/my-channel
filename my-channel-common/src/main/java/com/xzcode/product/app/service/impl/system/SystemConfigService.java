package com.xzcode.product.app.service.impl.system;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.system.SystemConfigMapper;
import com.xzcode.product.app.service.facade.system.ISystemConfigService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.system.SystemConfig;




/**
 * 系统配置表 service
 * 
 * @author zai & code generator
 * 2018-04-16 16:59:03
 */
@Service
public class SystemConfigService extends BaseService<SystemConfig> implements ISystemConfigService{
	
	@Autowired
	private SystemConfigMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}
	
	/**
	 * 先从缓存中取，缓冲中取不到在到数据库取
	 */
	public String getByKey(String key) {

		if (null != key && !"".equals(key.trim()) ) {
				String val =  this.jdbcLink.select(SystemConfig.class)
						.column(SystemConfig.V)
						.where()
							.and().eq(SystemConfig.K, key)
						.queryObject(String.class);
				
				if (val == "") {
					return null;
				}
				return val;
		}
		return null;
	}
	
	

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void setConfig(String key, String value) {
		
		this.jdbcLink.update(SystemConfig.class)
			.set()
				.param(SystemConfig.V, value)
			.where()
				.and().eq(SystemConfig.K, key)
			.execute()
			;
		 
	}
	

}

	


