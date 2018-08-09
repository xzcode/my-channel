package com.xzcode.product.app.service.impl.banner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.dao.banner.BannerInfoMapper;
import com.xzcode.product.app.service.facade.banner.IBannerInfoService;
import com.xzcode.product.app.service.impl.BaseService;
import com.xzcode.product.common.entity.banner.BannerInfo;




/**
 * 轮播图信息表 service
 * 
 * @author zai & code generator
 * 2018-04-16 16:59:02
 */
@Service
public class BannerInfoService extends BaseService<BannerInfo> implements IBannerInfoService{
	
	@Autowired
	private BannerInfoMapper mapper;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@PostConstruct
	public void setBaseMapper() {
		super.setBaseMapper(mapper);
	}

}

	


