package com.xzcode.product.app.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.jdbclink.core.models.Pager;
import com.xzcode.product.app.model.datatables.DataTablesResponse;
import com.xzcode.product.app.service.facade.admin.IAdminUserService;
import com.xzcode.product.app.utils.DataTablesResponseUtil;
import com.xzcode.product.common.entity.admin.AdminRole;
import com.xzcode.product.common.entity.admin.AdminUser;
import com.xzcode.product.common.entity.admin.AdminUserRole;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 系统用户 controller
 * 
 * @author zai & code generator
 * 2017-07-26 14:26:59
 */
@Controller
@RequestMapping(AdminUserController.basePath)
public class AdminUserController{
	
	public static final String basePath = "admin/adminuser";
	
	@Autowired
	private IAdminUserService adminUserService;
	
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
			.select(AdminUser.class, "au")
				.column("au", "*")
			.column("ar", AdminRole.ROLE_NAME)
				
			.leftJoin(AdminUserRole.class, "aur")
				.on().eq("aur", AdminUserRole.USER_ID, "au", AdminUser.UID)
			.leftJoin(AdminRole.class, "ar")
				.on().eq("aur", AdminUserRole.ROLE_ID, "ar", AdminRole.UID)
			.where()
				.or(keyword != null).fuzzyLike("au",AdminUser.REALNAME, keyword)
				.or(keyword != null).fuzzyLike("au",AdminUser.MOBILE, keyword)
				.or(keyword != null).fuzzyLike("au",AdminUser.USERNAME, keyword)
				
			.orderByDesc("au", AdminUser.CREATE_DATE)
			
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
					.select(AdminUser.class, "au")
						.column("au", "*")
					.column("ar", AdminRole.ROLE_NAME)
						
					.leftJoin(AdminUserRole.class, "aur")
						.on().eq("aur", AdminUserRole.USER_ID, "au", AdminUser.UID)
					.leftJoin(AdminRole.class, "ar")
						.on().eq("aur", AdminUserRole.ROLE_ID, "ar", AdminRole.UID)
					.where()
						.andGroup(StringUtils.isNotEmpty(keyword))
							.or().fuzzyLike("au",AdminUser.REALNAME, keyword)
							.or().fuzzyLike("au",AdminUser.MOBILE, keyword)
							.or().fuzzyLike("au",AdminUser.USERNAME, keyword)
						.endGroup()
						
					.orderBySorting(orderBy, sorting)
					.limitStarts(start, pageSize)
					
					.pageListMap();
		
    	return DataTablesResponseUtil.parse(pager, draw);
    }
    
    
    
    @RequestMapping(value = "/view/add")
    public ModelAndView viewAdd(ModelAndView mav){
    	
    	List<AdminRole> roles = this.jdbcLink.select(AdminRole.class).orderByAsc(AdminRole.CREATE_DATE).queryList();
    	mav.addObject("roles", roles);
    	mav.setViewName(basePath + "/add");
    	return mav;
    }
    
    @Transactional
    @RequestMapping(value = "/ajax/add/save")
    @ResponseBody
    public AjaxResponse ajaxAddSave(AdminUser t, @RequestParam Long roleId){
    	//插入数据
    	t.setCreateDate(new Date());
    	t.setUpdateDate(t.getCreateDate());
    	t.setPassword(DigestUtils.md5Hex(t.getPassword()));
    	this.jdbcLink.insertSelective(t);
    	
    	//插入关联
    	AdminUserRole adminUserRole = new AdminUserRole();
    	adminUserRole.setRoleId(roleId);
    	adminUserRole.setUserId(t.getUid());
    	this.jdbcLink.insert(adminUserRole);
    	
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/view/edit")
    public ModelAndView edit(ModelAndView mav, @RequestParam Long uid){
    	
    	AdminUser editObj = this.jdbcLink.select(uid, AdminUser.class);
    	mav.addObject("editObj", editObj);
    	
    	List<AdminRole> roles = this.jdbcLink.select(AdminRole.class).orderByAsc(AdminRole.CREATE_DATE).queryList();
    	mav.addObject("roles", roles);
    	
    	AdminUserRole adminUserRole = this.jdbcLink.select(AdminUserRole.class).where().and().eq(AdminUserRole.USER_ID, editObj.getUid()).queryEntity();
    	if (adminUserRole != null) {
    		mav.addObject("roleId", adminUserRole.getRoleId());			
		}
    	
    	
    	mav.setViewName(basePath + "/edit");
    	return mav;
		
    }
    
    @Transactional
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(AdminUser editObj, @RequestParam Long roleId){
    	
    	editObj.setUpdateDate(new Date());
    	if (StringUtils.isNotEmpty(editObj.getPassword())) {
    		editObj.setPassword(DigestUtils.md5Hex(editObj.getPassword()));			
		}else {
			editObj.setPassword(null);
		}
    	this.jdbcLink.update(editObj);
    	
    	//删除旧关联
    	this.jdbcLink.delete(AdminUserRole.class).where().and().eq(AdminUserRole.USER_ID, editObj.getUid()).execute();
    	
    	AdminUserRole adminUserRole = new AdminUserRole();
    	adminUserRole.setRoleId(roleId);
    	adminUserRole.setUserId(editObj.getUid());
    	this.jdbcLink.insert(adminUserRole);
    	
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    public AjaxResponse ajaxDelete(@RequestParam Long uid){
    	//this.adminUserService.deleteByPrimaryKey(uid);
    	//this.jdbcLink.delete(uid, AdminUser.class);
    	this.jdbcLink.update(AdminUser.class)
    	.set()
    		.param(AdminUser.ENABLED, AdminUser.EnabledConstant.NO)
    	.where()
    		.and().eq(AdminUser.UID, uid)
		.execute();
    	return AjaxResponse.success();
    }
    
    @RequestMapping(value = "/ajax/delete/flag")
    @ResponseBody
    public AjaxResponse ajaxDeleteFlag(
    		@RequestParam Long uid, 
    		Integer delFlag){
    	/*
    	this.jdbcLink.update(AdminUser.class)
    	.set()
    		.param(AdminUser.DEL_FLAG, AdminUser.TypeConstant.YES)
    	.where()
    		.and().eq(AdminUser.UID, uid)
		.execute();
		*/
    	return AjaxResponse.success();
		
    }
    
    @RequestMapping(value = "/ajax/get")
    @ResponseBody
    public AjaxResponse ajaxGet(
    		@RequestParam Long uid){
    	return AjaxResponse.success().setData(this.jdbcLink.select(uid, AdminUser.class));
    }
    
    @RequestMapping(value = "/view/show")
    public ModelAndView viewShow(
    		ModelAndView mav, 
    		@RequestParam Long uid
    		){
    	AdminUser showObj = this.jdbcLink.select(uid, AdminUser.class);
    	mav.addObject("showObj", showObj);
    	mav.setViewName(basePath + "/show");
    	return mav;
    }
	
	
}
