package com.xzcode.product.app.service.impl.version;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.version.VersionMapper;
import com.xzcode.product.app.service.facade.version.IVersionService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.version.Version;




/**
 * 版本信息表 service
 * 
 * @author zai & code generator
 * 2018-04-16 16:59:03
 */
@Service
public class VersionService extends BaseService<Version> implements IVersionService{
	
	@Autowired
	private VersionMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


