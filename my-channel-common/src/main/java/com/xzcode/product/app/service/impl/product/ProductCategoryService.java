package com.xzcode.product.app.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xzcode.jdbclink.core.JdbcLink;
import javax.annotation.PostConstruct;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.app.dao.product.ProductCategoryMapper;
import com.xzcode.product.common.entity.product.ProductCategory;
import com.xzcode.product.app.service.facade.product.IProductCategoryService;




/**
 *  service
 * 
 * @author jdbclink code generator & code generator
 * 2018-06-27 22:56:17
 */
@Service
public class ProductCategoryService extends BaseService<ProductCategory> implements IProductCategoryService{
	
	@Autowired
	private ProductCategoryMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


