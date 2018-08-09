package com.xzcode.product.app.controller.version;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.jdbclink.core.models.Pager;
import com.xzcode.product.app.model.datatables.DataTablesResponse;
import com.xzcode.product.app.service.facade.version.IVersionService;
import com.xzcode.product.app.utils.DataTablesResponseUtil;
import com.xzcode.product.common.entity.version.Version;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 版本信息表 controller
 * 
 * @author jdbclink code generator
 * 2018-05-17 18:10:31
 */
@Controller
@RequestMapping(VersionController.basePath)
public class VersionController{

	private static final Logger logger = LoggerFactory.getLogger(VersionController.class);
	
	public static final String basePath = "version/version";
	
	@Autowired
	private IVersionService versionService;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	
	/**
	 * 视图
	 * @param request
	 * @param mav
	 * @return
	 * 
	 * @author jdbclink code generator
	 * 2018-05-17 18:10:31
	 */
	@RequestMapping(value = "/view/list")
    public ModelAndView viewList(
    		HttpServletRequest request,
    		ModelAndView mav
    		){
		
		mav.setViewName(basePath + "/list");
    	return mav;
    }
    
    /**
	 * ajax 列表数据
	 * @param request
	 * @param draw
	 * @param start
	 * @param pageSize
	 * @param orderBy
	 * @param sorting
	 * @param keyword
	 * @return
	 * 
	 * @author jdbclink code generator
	 * 2018-05-17 18:10:31
	 */
	@RequestMapping(value = "/ajax/list")
	@ResponseBody
    public DataTablesResponse ajaxList(
    		HttpServletRequest request,
    		Integer draw,
    		Integer start,
    		Integer pageSize,
    		String orderBy,
    		String sorting,
    		String keyword
    		){
		
		Pager<Map<String, Object>> pager = 
				
		this.jdbcLink
			.select(Version.class, "a")
				.column("a", "*")
				
			/*
			.leftJoin(UserInfo.class, "u")
				.on().eq("u", UserInfo.UID, "a", Version.USER_ID)
			*/
			
			
				
			.where()
			.andGroup()
			/*
					.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("a", UserInfo.MOBILE, keyword)
					.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("a", UserInfo.USERNAME, keyword)
			*/
			.endGroup()
			
			
				
			.orderBySorting(orderBy, sorting)
			
			.limitStarts(start, pageSize)
			.pageListMap();
		
    	return DataTablesResponseUtil.parse(pager, draw);
    }
    
    /**
	 * id获取实体Map
	 * 
	 * @author jdbclink code generator
	 * 2018-05-17 18:10:31
	 */
    private Map<String, Object> queryEntityMap(Long uid) {
    
    	return this.jdbcLink
			.select(Version.class, "a")
				.column("a", "*")
				
			/*	
			.leftJoin(UserInfo.class, "u")
				.on().eq("u", UserInfo.UID, "a", Version.USER_ID)
			*/
			
			.where()
				.and().eq("a", Version.UID, uid)
			.queryMap();
    
    }

    /**
	 * 数据展示视图
	 * 
	 * @author jdbclink code generator
	 * 2018-05-17 18:10:31
	 */
    @RequestMapping(value = "/view/show")
    public ModelAndView viewShow(
    		ModelAndView mav, 
    		@RequestParam Long uid
    		){
    	Map<String, Object> editObj = queryEntityMap(uid);
    	mav.addObject("editObj", editObj);
    	mav.setViewName(basePath + "/show");
    	return mav;
    }
    
    /**
	 * 数据视图
	 * 
	 * @author jdbclink code generator
	 * 2018-05-17 18:10:31
	 */
    @RequestMapping(value = "/view/add")
    public ModelAndView viewAdd(ModelAndView mav){
    	mav.setViewName(basePath + "/add");
    	return mav;
    }
    
    /**
	 * ajax数据实体保存请求
	 * 
	 * @author jdbclink code generator
	 * 2018-05-17 18:10:31
	 */
    @RequestMapping(value = "/ajax/add/save")
    @ResponseBody
    public AjaxResponse ajaxAddSave(Version editObj){
    	editObj.setCreateDate(new Date());
    	this.jdbcLink.insert(editObj);
    	return AjaxResponse.success();
    }
    
    /**
	 * 数据编辑视图
	 * 
	 * @author jdbclink code generator
	 * 2018-05-17 18:10:31
	 */
    @RequestMapping(value = "/view/edit")
    public ModelAndView edit(ModelAndView mav, @RequestParam Long uid){
    
    	Map<String, Object> editObj = queryEntityMap(uid);
    	mav.addObject("editObj", editObj);
    	
    	mav.setViewName(basePath + "/edit");
    	return mav;
		
    }
    
    /**
	 * ajax实体编辑保存
	 * 
	 * @author jdbclink code generator
	 * 2018-05-17 18:10:31
	 */
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(Version editObj){
    	this.jdbcLink.update(editObj);
    	return AjaxResponse.success();
    }
    
    /**
	 * 删除或失效数据
	 * 
	 * @author jdbclink code generator
	 * 2018-05-17 18:10:31
	 */
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    public AjaxResponse ajaxDelete(@RequestParam Long uid){
    	/*
    	this.jdbcLink.delete(uid, Version.class);
		*/
    	
    	return AjaxResponse.success();
    }
	
}
