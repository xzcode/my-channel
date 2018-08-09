package com.xzcode.product.app.controller.area;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.jdbclink.core.models.Pager;
import com.xzcode.product.app.service.facade.area.IAreaService;
import com.xzcode.product.common.entity.area.Area;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 地理位置表 controller
 * 
 * @author zai & code generator
 * 2017-08-16 10:33:42
 */
@Controller
@RequestMapping(AreaController.basePath)
public class AreaController{
	
	public static final String basePath = "area/area";
	
	@Autowired
	private IAreaService areaService;
	
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
			.select(Area.class, "a")
				.column("a", "*")
				/*.concat(
						"alias",
						new ConcatColumn(Area.__, Area.NAME),
						new ConcatValue("--"),
						new ConcatColumn(Area.__, Area.SHORTNAME)
					)*/
				
			/*
			.leftJoin(User.class, "u")
				.on().eq("u", User.UID, "a", Area.USER_ID)
			
			.where()
				.or(keyword != null).fuzzyLike("a",Area.TITLE, keyword)
			
			.orderByDesc("a", Area.CREATE_DATE)
			*/
			.limit(pageNo, pageSize)
			
			.pageListMap();
		
		mav.addObject("pager", pager);
		mav.setViewName(basePath + "/list");
    	return mav;
    }

    @RequestMapping(value = "/ajax/list/page")
    @ResponseBody
    public AjaxResponse ajaxListPage(
    		HttpServletRequest request,
    		Integer pageNo,
    		Integer pageSize,
    		String keyword
    		){    
		Pager<Map<String, Object>> pager = 
				
		this.jdbcLink
			.select(Area.class, "a")
				.column("a", "*")
				
			/*
			.leftJoin(User.class, "u")
				.on().eq("u", User.UID, "e", Area.USER_ID)
			
			.where()
				.or(keyword != null).fuzzyLike("a",Area.TITLE, keyword)
			*/
			.orderBy("a", Area.UID)
			
			.limit(pageNo, pageSize)
			
			.pageListMap();
    	return AjaxResponse.success().setData(pager);
    }
    
    /**
     * 获取省列表
     * @param request
     * @return
     * 
     * @author zai
     * 2017-08-16
     */
    @RequestMapping(value = "/ajax/province")
    @ResponseBody
    public AjaxResponse ajaxProvince(
    		HttpServletRequest request
    		){    
				
		List<Map<String, Object>> list = 
				this.jdbcLink
					.select(Area.class, "a")
						.column("a", "*")
						
					.where()
						.and().eq(Area.LAYER, 1)
						
					.orderBy("a", Area.UID)
					
					.queryListMap();
		
    	return AjaxResponse.success().setData(list);
    }
    
    /**
     * 获取市列表
     * @param request
     * @param provinceId
     * @return
     * 
     * @author zai
     * 2017-08-16
     */
    @RequestMapping(value = "/ajax/city")
    @ResponseBody
    public AjaxResponse ajaxCity(
    		HttpServletRequest request,
    		@RequestParam Integer provinceId
    		){    
				
		List<Map<String, Object>> list = 
				this.jdbcLink
					.select(Area.class, "a")
						.column("a", "*")
						
					.where()
						.and().eq(Area.LAYER, 2)
						.and().eq(Area.AREA_ID, provinceId)
						
					.orderBy("a", Area.UID)
					
					.queryListMap();
		
    	return AjaxResponse.success().setData(list);
    }
    
    /**
     * 获取区/县列表
     * @param request
     * @param cityId
     * @return
     * 
     * @author zai
     * 2017-08-16
     */
    @RequestMapping(value = "/ajax/area")
    @ResponseBody
    public AjaxResponse ajaxArea(
    		HttpServletRequest request,
    		@RequestParam Integer cityId
    		){    
				
		List<Map<String, Object>> list = 
				this.jdbcLink
					.select(Area.class, "a")
						.column("a", "*")
						
					.where()
						.and().eq(Area.LAYER, 3)
						.and().eq(Area.AREA_ID, cityId)
						
					.orderBy("a", Area.UID)
					
					.queryListMap();
		
    	return AjaxResponse.success().setData(list);
    }
    
    
    
    @RequestMapping(value = "/view/add")
    public ModelAndView viewAdd(ModelAndView mav){
    	mav.setViewName(basePath + "/add");
    	return mav;
    }
    
    @RequestMapping(value = "/ajax/add/save")
    @ResponseBody
    public AjaxResponse ajaxAddSave(Area editObj){
    	/*
    	t.setCreateDate(new Date());
    	t.setCreateBy(SessionUtils.getAdmin().getUid());
    	t.setUpdateDate(editObj.getCreateDate());
    	t.setUpdateBy(SessionUtils.getAdmin().getUid());
    	*/
    	this.jdbcLink.insert(editObj);
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/view/edit")
    public ModelAndView edit(ModelAndView mav, @RequestParam Long uid){
    
    	Area editObj = this.jdbcLink.select(uid, Area.class);
    	mav.addObject("editObj", editObj);
    	
    	mav.setViewName(basePath + "/edit");
    	return mav;
		
    }
    
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(Area editObj){
    	/*
    	editObj.setUpdateDate(new Date());
    	editObj.setUpdateBy(SessionUtils.getAdmin().getUid());
    	*/
    	this.jdbcLink.update(editObj);
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    public AjaxResponse ajaxDelete(@RequestParam Long uid){
    	this.jdbcLink.delete(uid, Area.class);
    	
    	/*
    	this.jdbcLink.update(Area.class)
    	.set()
    		.param(Area.DEL_FLAG, Area.DelFlagConstant.YES)
    	.where()
    		.and().eq(Area.UID, uid)
		.execute();
		*/
    	
    	
    	return AjaxResponse.success();
    }
    
    @RequestMapping(value = "/ajax/get")
    @ResponseBody
    public AjaxResponse ajaxGet(
    		@RequestParam Long uid){
    	return AjaxResponse.success().setData(this.jdbcLink.select(uid, Area.class));
    }
    
    @RequestMapping(value = "/view/show")
    public ModelAndView viewShow(
    		ModelAndView mav, 
    		@RequestParam Long uid
    		){
    	Area showObj = this.jdbcLink.select(uid, Area.class);
    	mav.addObject("showObj", showObj);
    	mav.setViewName(basePath + "/show");
    	return mav;
    }
	
	
}
