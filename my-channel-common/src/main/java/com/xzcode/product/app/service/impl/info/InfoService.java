package com.xzcode.product.app.service.impl.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xzcode.jdbclink.core.JdbcLink;
import javax.annotation.PostConstruct;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.app.dao.info.InfoMapper;
import com.xzcode.product.common.entity.info.Info;
import com.xzcode.product.app.service.facade.info.IInfoService;




/**
 * 行业资讯信息表 service
 * 
 * @author jdbclink code generator & code generator
 * 2018-06-27 22:56:17
 */
@Service
public class InfoService extends BaseService<Info> implements IInfoService{
	
	@Autowired
	private InfoMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


