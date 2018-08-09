package com.xzcode.product.app.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.helper.CachedDataHelper;
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;
import com.xzcode.product.cache.CacheService;
import com.xzcode.product.common.entity.banner.BannerInfo;
import com.xzcode.product.common.entity.info.Info;
import com.xzcode.product.common.entity.product.ProductCategory;
import com.xzcode.product.common.entity.successful.SuccessfulCase;


@Controller
@RequestMapping
public class IndexController {
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@Autowired
	private CacheService cacheService;
	
	@Autowired
	private CachedDataHelper cachedDataHelper;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Autowired
	private IAdminPermissionService adminPermissionService;
	
	
	@RequestMapping("/")
	public String index() {
		
			
		return "redirect:/index.html";
	}
	@Transactional
	@RequestMapping("/index")
	public ModelAndView index2(ModelAndView mav) {
		
		Connection connection1 = DataSourceUtils.getConnection(dataSource);
		Connection connection2 = DataSourceUtils.getConnection(dataSource);
		Connection connection3 = DataSourceUtils.getConnection(dataSource);
		Connection connection4 = DataSourceUtils.getConnection(dataSource);
		
		System.out.println(connection1);
		System.out.println(connection2);
		System.out.println(connection3);
		System.out.println(connection4);
		
		mav.addObject("bannerInfos", getBannerInfos());
		
		mav.addObject("productCategories", getProductCategories());
		
		mav.addObject("successfulCases", getSuccessfulCases());
		
		mav.addObject("infos", getInfos());
		
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 获取首页滚动图片
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 15:30:49
	 */
	private List<BannerInfo> getBannerInfos() {
		return this.jdbcLink.select(BannerInfo.class).orderByDesc(BannerInfo.SORT).queryList();
		
	}
	
	/**
	 * 获取产品分类信息
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 15:31:50
	 */
	private List<ProductCategory> getProductCategories() {
		return  cachedDataHelper.getProductCategories();
		
	}
	
	/**
	 * 获取成功案例
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 15:31:50
	 */
	private List<SuccessfulCase> getSuccessfulCases() {
		return this.jdbcLink.select(SuccessfulCase.class)
		.orderByDesc(SuccessfulCase.HOT_NUM)
		.orderByDesc(SuccessfulCase.SORT)
		.limit(3)
		.queryList();
		
	}

	
	/**
	 * 获取成功案例
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 15:31:50
	 */
	private List<Info> getInfos() {
		return this.jdbcLink.select(Info.class)
				.orderByDesc(Info.HOT_NUM)
				.orderByDesc(Info.SORT)
				.limit(4)
				.queryList();
		
	}
    
}
