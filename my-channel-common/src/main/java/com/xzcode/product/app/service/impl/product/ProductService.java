package com.xzcode.product.app.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xzcode.jdbclink.core.JdbcLink;
import javax.annotation.PostConstruct;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.app.dao.product.ProductMapper;
import com.xzcode.product.common.entity.product.Product;
import com.xzcode.product.app.service.facade.product.IProductService;




/**
 * 行业资讯信息表 service
 * 
 * @author jdbclink code generator & code generator
 * 2018-06-27 22:56:17
 */
@Service
public class ProductService extends BaseService<Product> implements IProductService{
	
	@Autowired
	private ProductMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


