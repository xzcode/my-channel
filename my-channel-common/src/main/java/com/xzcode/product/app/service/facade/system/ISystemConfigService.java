package com.xzcode.product.app.service.facade.system;

import com.xzcode.product.app.service.facade.IBaseService;
import com.xzcode.product.common.entity.system.SystemConfig;

/**
 * 系统配置表 service 接口
 * 
 * @author zai
 * 2018-04-16 17:10:09
 */
public interface ISystemConfigService extends IBaseService<SystemConfig>{
	
	String CustomerServiceNumber = "CustomerServiceNumber";    //客服电话1号               
	String CustomerServiceNumber2 = "CustomerServiceNumber2";  //客服电话2号               
	String WorkingTimeInfo = "WorkingTimeInfo";                //工作时间信息               
	String CompanyName = "CompanyName";                        //公司名称                 
	String WebCopyrightInfo = "WebCopyrightInfo";              //网站版权与备案信息            
	String SeoDefaultTitle = "SeoDefaultTitle";                //网站默认seo标题-title      
	String SeoDefaultKeywords = "SeoDefaultKeywords";          //网站默认seo关键字-keywords  
	String SeoDefaultDescription = "SeoDefaultDescription";    //网站默认seo说明-description
	String CompanyAddress = "CompanyAddress";                  //公司地址                 
	String CompanyPostalCode = "CompanyPostalCode";            //公司邮政编码               

	/**
	 * 先从缓存中取，缓冲中取不到在到数据库取
	 * @param key
	 * @return
	 */
	String getByKey(String key);
	
	/**
	 * 更新系统配置
	 * @param key
	 * @param value
	 * @return
	 */
	void setConfig(String key, String value);
	
	
}

	


