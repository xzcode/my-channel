package com.xzcode.product.app.controller.admin;

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
import com.xzcode.product.app.service.facade.admin.IAdminRolePermissionService;
import com.xzcode.product.app.utils.DataTablesResponseUtil;
import com.xzcode.product.common.entity.admin.AdminRolePermission;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 用户权限角色对应关系表 controller
 * 
 * @author jdbclink code generator
 * 2018-05-16 17:44:39
 */
@Controller
@RequestMapping(AdminRolePermissionController.basePath)
public class AdminRolePermissionController{

	private static final Logger logger = LoggerFactory.getLogger(AdminRolePermissionController.class);
	
	public static final String basePath = "admin/adminrolepermission";
	
	@Autowired
	private IAdminRolePermissionService adminRolePermissionService;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	
	/**
	 * 视图
	 * @param request
	 * @param mav
	 * @return
	 * 
	 * @author jdbclink code generator
	 * 2018-05-16 17:44:39
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
	 * 2018-05-16 17:44:39
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
			.select(AdminRolePermission.class, "a")
				.column("a", "*")
				
			.where()
			/*
				.andGroup()
					.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("a", AdminRolePermission.MOBILE, keyword)
					.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("a", AdminRolePermission.USERNAME, keyword)
				.endGroup()
				
				.and(enabled != null).eq("a", AdminRolePermission.ENABLED, enabled)
			*/
				
			.orderBySorting(orderBy, sorting)
			
			//.orderByDesc(StringUtils.isEmpty(orderBy),"a", AdminRolePermission.CREATE_DATE)
			
			.limitStarts(start, pageSize)
			.pageListMap();
		
    	return DataTablesResponseUtil.parse(pager, draw);
    }
    
    /**
	 * id获取实体Map
	 * 
	 * @author jdbclink code generator
	 * 2018-05-16 17:44:39
	 */
    private Map<String, Object> queryEntityMap(Long uid) {
    
    	/*	
    	return this.jdbcLink
			.select(AdminRolePermission.class, AdminRolePermission.__)
				.column(AdminRolePermission.__, "*")
			.leftJoin(UserInfo.class, UserInfo.__)
				.on().eq(UserInfo.__, UserInfo.UID, AdminRolePermission.__, AdminRolePermission.USER_ID)
			.where()
				.and().eq(AdminRolePermission.__, AdminRolePermission.UID, uid)
			.queryMap();
    	 */
    	return null;
    
    }

    /**
	 * 数据展示视图
	 * 
	 * @author jdbclink code generator
	 * 2018-05-16 17:44:39
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
	 * 2018-05-16 17:44:39
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
	 * 2018-05-16 17:44:39
	 */
    @RequestMapping(value = "/ajax/add/save")
    @ResponseBody
    public AjaxResponse ajaxAddSave(AdminRolePermission editObj){
    	/*
    	editObj.setCreateDate(new Date());
    	*/
    	this.jdbcLink.insert(editObj);
    	return AjaxResponse.success();
    }
    
    /**
	 * 数据编辑视图
	 * 
	 * @author jdbclink code generator
	 * 2018-05-16 17:44:39
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
	 * 2018-05-16 17:44:39
	 */
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(AdminRolePermission editObj){
    	this.jdbcLink.update(editObj);
    	return AjaxResponse.success();
    }
    
    /**
	 * 删除或失效数据
	 * 
	 * @author jdbclink code generator
	 * 2018-05-16 17:44:39
	 */
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    public AjaxResponse ajaxDelete(@RequestParam Long uid){
    	/*
    	this.jdbcLink.delete(uid, AdminRolePermission.class);
		*/
    	
    	return AjaxResponse.success();
    }
	
}
