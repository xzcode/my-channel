package com.xzcode.product.app.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.service.facade.system.ISystemConfigService;
import com.xzcode.product.common.entity.product.ProductCategory;

/**
 * 已缓存数据工具类
 * 
 * 
 * @author zai
 * 2018-07-04 19:23:01
 */
@Service
public class CachedDataHelper {
	
	@Autowired
	private ISystemConfigService systemConfigService;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	/**
	 * 获取产品分类信息
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 20:38:20
	 */
	public List<ProductCategory> getProductCategories() {
		return this.jdbcLink.select(ProductCategory.class).orderByAsc(ProductCategory.SORT).queryList();
	}
	
	/**
	 * 获取默认seo标题
	 * @param defVal 默认值
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 19:27:35
	 */
	public String getSeoDefaultTitle() {
		return systemConfigService.getByKey(ISystemConfigService.SeoDefaultTitle);
		
	}
	
	
	/**
	 * 获取默认seo关键字
	 * @param defVal 默认值
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 19:27:35
	 */
	public String getSeoDefaultKeywords() {
		return systemConfigService.getByKey(ISystemConfigService.SeoDefaultKeywords);
		
			
	}
	
	
	/**
	 * 获取默认seo说明
	 * @param defVal 默认值
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 19:27:35
	 */
	public String getSeoDefaultDescription() {
		return systemConfigService.getByKey(ISystemConfigService.SeoDefaultDescription);
	}
	
	
	/**
	 * 获取版权信息
	 * @param defVal
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 20:12:57
	 */
	public String getWebCopyrightInfo() {
		return systemConfigService.getByKey(ISystemConfigService.WebCopyrightInfo);
	}
	
	/**
	 * 获取客服电话
	 * @param defVal
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 20:12:57
	 */
	public String getCustomerServiceNumber() {
		return systemConfigService.getByKey(ISystemConfigService.CustomerServiceNumber);
	}
	
	/**
	 * 获取客服电话2号
	 * @param defVal
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 20:12:57
	 */
	public String getCustomerServiceNumber2() {
		return systemConfigService.getByKey(ISystemConfigService.CustomerServiceNumber2);
	}
	
	/**
	 * 获取工作时间
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 20:19:10
	 */
	public String getWorkingTimeInfo() {
		return systemConfigService.getByKey(ISystemConfigService.WorkingTimeInfo);
	}
	
	/**
	 * 公司名称
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 20:19:10
	 */
	public String getCompanyName() {
		return systemConfigService.getByKey(ISystemConfigService.CompanyName);
	}
	
	/**
	 * 公司地址
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 20:19:10
	 */
	public String getCompanyAddress() {
		return systemConfigService.getByKey(ISystemConfigService.CompanyAddress);
	}
	
	/**
	 * 邮政编码
	 * @return
	 * 
	 * @author zai
	 * 2018-07-04 20:19:10
	 */
	public String getCompanyPostalCode() {
		return systemConfigService.getByKey(ISystemConfigService.CompanyPostalCode);
	}
	
	
	
	
	
}
