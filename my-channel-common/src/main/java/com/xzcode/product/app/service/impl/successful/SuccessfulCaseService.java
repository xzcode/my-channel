package com.xzcode.product.app.service.impl.successful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xzcode.jdbclink.core.JdbcLink;
import javax.annotation.PostConstruct;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.app.dao.successful.SuccessfulCaseMapper;
import com.xzcode.product.common.entity.successful.SuccessfulCase;
import com.xzcode.product.app.service.facade.successful.ISuccessfulCaseService;




/**
 * 成功案例信息表 service
 * 
 * @author jdbclink code generator & code generator
 * 2018-06-28 00:24:31
 */
@Service
public class SuccessfulCaseService extends BaseService<SuccessfulCase> implements ISuccessfulCaseService{
	
	@Autowired
	private SuccessfulCaseMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


