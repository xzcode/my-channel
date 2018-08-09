package com.xzcode.product.app.controller.system;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.jdbclink.core.models.Pager;
import com.xzcode.product.app.model.datatables.DataTablesResponse;
import com.xzcode.product.app.service.facade.system.ISystemConfigService;
import com.xzcode.product.app.utils.DataTablesResponseUtil;
import com.xzcode.product.common.entity.system.SystemConfig;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 系统配置表 controller
 * 
 * @author zai & code generator
 * 2017-08-02 17:50:18
 */
@Controller
@RequestMapping(SystemConfigController.basePath)
public class SystemConfigController{
	
	public static final String basePath = "system/systemconfig";
	
	@Autowired
	private ISystemConfigService systemConfigService;
	
	@Autowired
	private JdbcLink jdbcLink;

	
	@RequestMapping(value = "/view/list")
    public ModelAndView viewList(
    		HttpServletRequest request,
    		ModelAndView mav, 
    		Integer pageNo,
    		Integer pageSize,
    		String keyword
    		){
		
		Pager<Map<String, Object>> pager = 
				
		this.jdbcLink
			.select(SystemConfig.class, "a")
				.column("a", "*")
				
			/*
			.leftJoin(User.class, "u")
				.on().eq("u", User.UID, "e", SystemConfig.USER_ID)
			*/
			.where()
				.and().eq("a",SystemConfig.IS_CAN_CONFIG, SystemConfig.IsCanConfigConstant.ALLOW)
				.andGroup(StringUtils.isNotEmpty(keyword))
					.and().fuzzyLike("a",SystemConfig.K, keyword)
				.endGroup()
			
			.orderByDesc("a", SystemConfig.CREATE_DATE)
			
			.limit(pageNo, pageSize)
			
			.pageListMap();
		
		mav.addObject("pager", pager);
		mav.setViewName(basePath + "/list");
    	return mav;
    }

	@RequestMapping(value = "/ajax/list")
	@ResponseBody
    public DataTablesResponse ajaxList(
    		HttpServletRequest request,
    		Integer draw,
    		Integer start,
    		Integer pageSize,
    		String orderBy,
    		String sorting,
    		String keyword,
    		Integer enabled
    		){
		
		Pager<Map<String, Object>> pager = 
				
				this.jdbcLink
				.select(SystemConfig.class, "a")
				.column("a", "*")
				
				.where()
					.and().eq("a",SystemConfig.IS_CAN_CONFIG, SystemConfig.IsCanConfigConstant.ALLOW)
					
					.andGroup(StringUtils.isNotEmpty(keyword))
						.and().fuzzyLike("a",SystemConfig.K, keyword)
						.and().fuzzyLike("a",SystemConfig.REMARK, keyword)
					.endGroup()
				
				.orderBySorting(orderBy, sorting)
					
				.limitStarts(start, pageSize)
				
				
				.pageListMap();
		
    	return DataTablesResponseUtil.parse(pager, draw);
    }
    
    
    
    @RequestMapping(value = "/view/add")
    public ModelAndView viewAdd(ModelAndView mav){
    	mav.setViewName(basePath + "/add");
    	return mav;
    }
    
    @RequestMapping(value = "/ajax/add/save")
    @ResponseBody
    public AjaxResponse ajaxAddSave(SystemConfig editObj){
    	/*
    	t.setCreateDate(new Date());
    	t.setCreateBy(SessionUtils.getAdmin().getUid());
    	t.setUpdateDate(editObj.getCreateDate());
    	t.setUpdateBy(SessionUtils.getAdmin().getUid());
    	*/
    	editObj.setCreateDate(new Date());
    	this.jdbcLink.insert(editObj);
    	this.systemConfigService.setConfig(editObj.getK(), editObj.getV());
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/view/edit")
    public ModelAndView edit(ModelAndView mav, @RequestParam Long uid){
    
    	SystemConfig editObj = this.jdbcLink.select(uid, SystemConfig.class);
    	mav.addObject("editObj", editObj);
    	
    	mav.setViewName(basePath + "/edit");
    	return mav;
		
    }
    
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(SystemConfig editObj){
    	/*
    	editObj.setUpdateDate(new Date());
    	editObj.setUpdateBy(SessionUtils.getAdmin().getUid());
    	*/
    	//this.jdbcLink.update(editObj);
    	this.systemConfigService.setConfig(editObj.getK(), editObj.getV());
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    public AjaxResponse ajaxDelete(@RequestParam Long uid){
    	this.systemConfigService.deleteByPrimaryKey(uid);
    	this.jdbcLink.delete(uid, SystemConfig.class);
    	return AjaxResponse.success();
    }
    
    @RequestMapping(value = "/ajax/delete/flag")
    @ResponseBody
    public AjaxResponse ajaxDeleteFlag(
    		@RequestParam Long uid, 
    		Integer delFlag){
    	/*
    	this.jdbcLink.update(SystemConfig.class)
    	.set()
    		.param(SystemConfig.DEL_FLAG, SystemConfig.TypeConstant.YES)
    	.where()
    		.and().eq(SystemConfig.UID, uid)
		.execute();
		*/
    	return AjaxResponse.success();
		
    }
    
    @RequestMapping(value = "/ajax/get")
    @ResponseBody
    public AjaxResponse ajaxGet(
    		@RequestParam Long uid){
    	return AjaxResponse.success().setData(this.jdbcLink.select(uid, SystemConfig.class));
    }
    
    @RequestMapping(value = "/view/show")
    public ModelAndView viewShow(
    		ModelAndView mav, 
    		@RequestParam Long uid
    		){
    	SystemConfig showObj = this.jdbcLink.select(uid, SystemConfig.class);
    	mav.addObject("showObj", showObj);
    	mav.setViewName(basePath + "/show");
    	return mav;
    }
	
	
}
