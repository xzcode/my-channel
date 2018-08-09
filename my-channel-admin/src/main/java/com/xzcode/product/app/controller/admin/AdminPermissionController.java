package com.xzcode.product.app.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.jdbclink.core.models.Pager;
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;
import com.xzcode.product.app.utils.SessionUtils;
import com.xzcode.product.common.entity.admin.AdminPermission;
import com.xzcode.product.common.entity.admin.AdminRolePermission;
import com.xzcode.product.common.entity.admin.AdminUser;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 管理员权限 controller
 * 
 * @author zai & code generator
 * 2017-07-26 14:14:58
 */
@Controller
@RequestMapping(AdminPermissionController.basePath)
public class AdminPermissionController{
	
	public static final String basePath = "admin/adminpermission";
	
	@Autowired
	private IAdminPermissionService adminPermissionService;
	
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
			.select(AdminPermission.class, "a")
				.column("a", "*")
				
			/*
			.leftJoin(User.class, "u")
				.on().eq("u", User.UID, "e", AdminPermission.USER_ID)
			
			.where()
				.or(keyword != null).fuzzyLike("a",AdminPermission.TITLE, keyword)
			*/
			.orderByDesc("a", AdminPermission.CREATE_DATE)
			
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
			.select(AdminPermission.class, "a")
				.column("a", "*")
				
			/*
			.leftJoin(User.class, "u")
				.on().eq("u", User.UID, "e", AdminPermission.USER_ID)
			
			.where()
				.or(keyword != null).fuzzyLike("a",AdminPermission.TITLE, keyword)
			*/
			.orderByDesc("a", AdminPermission.CREATE_DATE)
			
			.limit(pageNo, pageSize)
			
			.pageListMap();
    	return AjaxResponse.success().setData(pager);
    }
    
    
    
    @RequestMapping(value = "/ajax/list/all")
    @ResponseBody
    public AjaxResponse ajaxListAll(
    		HttpServletRequest request,
    		String keyword
    		){    
				
		List<AdminPermission> list = this.jdbcLink
			.select(AdminPermission.class, "a")
				.column("a", "*")
			.orderByAsc("a", AdminPermission.SORT_ORDER)
			.queryList();
    	return AjaxResponse.success().setData(list);
    }
    
    
    
    @RequestMapping(value = "/view/add")
    public ModelAndView viewAdd(ModelAndView mav, @RequestParam Long parentId){
    	
    	AdminPermission parent = this.jdbcLink.select(parentId, AdminPermission.class);
    	mav.addObject("parent", parent);
    	mav.setViewName(basePath + "/add");
    	return mav;
    }
    
    @RequestMapping(value = "/ajax/add/save")
    @ResponseBody
    public AjaxResponse ajaxAddSave(AdminPermission editObj) throws Exception{
    	
    	AdminUser user = SessionUtils.getUser();
    	editObj.setCreateBy(user.getUid());
    	editObj.setCreateDate(new Date());
    	this.jdbcLink.insert(editObj);
    	
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/view/edit")
    public ModelAndView edit(ModelAndView mav, @RequestParam Long uid){
    
    	AdminPermission editObj = this.jdbcLink.select(uid, AdminPermission.class);
    	mav.addObject("editObj", editObj);
    	
    	if (editObj != null) {
    		AdminPermission parentObj = this.jdbcLink.select(editObj.getParentId(), AdminPermission.class);
    		mav.addObject("parentObj", parentObj);
    		
    		AdminUser adminUser = this.jdbcLink.select(editObj.getCreateBy(), AdminUser.class);
    		mav.addObject("createByUser", adminUser.getRealname());
    	}
    	
    	mav.setViewName(basePath + "/edit");
    	return mav;
		
    }
    
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(AdminPermission editObj) throws Exception{
    	/*
    	editObj.setUpdateDate(new Date());
    	editObj.setUpdateBy(SessionUtils.getAdmin().getUid());
    	*/
    	AdminUser user = SessionUtils.getUser();
    	editObj.setCreateBy(user.getUid());
    	
    	this.jdbcLink.update(editObj);
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    @Transactional
    public AjaxResponse ajaxDelete(@RequestParam Long uid){
    	if (uid.equals(0L)) {
			return AjaxResponse.fail();
		}
    	//删除父权限
    	this.jdbcLink.delete(uid, AdminPermission.class);
    	
    	//递归删除所有子权限
    	deleteSubPermissions(uid);
    	
    	//删除权限与角色关联
    	this.jdbcLink.delete(AdminRolePermission.class).where().and().eq(AdminRolePermission.PERMISSION_ID, uid).execute();
    	return AjaxResponse.success();
    }
    
    private void deleteSubPermissions(Long parentId) {
    	List<AdminPermission> permissions = this.jdbcLink.select(AdminPermission.class)
    		.where()
    			.and().eq(AdminPermission.PARENT_ID, parentId)
    		.queryList();
    	for (AdminPermission p : permissions) {
    		this.jdbcLink.delete(p.getUid(), AdminPermission.class);
    		deleteSubPermissions(p.getUid());
		}
    }
    
    @RequestMapping(value = "/ajax/delete/flag")
    @ResponseBody
    public AjaxResponse ajaxDeleteFlag(
    		@RequestParam Long uid, 
    		Integer delFlag){
    	/*
    	this.jdbcLink.update(AdminPermission.class)
    	.set()
    		.param(AdminPermission.DEL_FLAG, AdminPermission.TypeConstant.YES)
    	.where()
    		.and().eq(AdminPermission.UID, uid)
		.execute();
		*/
    	return AjaxResponse.success();
		
    }
    
    @RequestMapping(value = "/ajax/get")
    @ResponseBody
    public AjaxResponse ajaxGet(
    		@RequestParam Long uid){
    	return AjaxResponse.success().setData(this.jdbcLink.select(uid, AdminPermission.class));
    }
    
    @RequestMapping(value = "/view/show")
    public ModelAndView viewShow(
    		ModelAndView mav, 
    		@RequestParam Long uid
    		){
    	AdminPermission showObj = this.jdbcLink.select(uid, AdminPermission.class);
    	mav.addObject("showObj", showObj);
    	mav.setViewName(basePath + "/show");
    	return mav;
    }
	
	
}
