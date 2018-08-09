package com.xzcode.product.app.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

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
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;
import com.xzcode.product.app.service.facade.admin.IAdminRoleService;
import com.xzcode.product.app.utils.DataTablesResponseUtil;
import com.xzcode.product.app.utils.SessionUtils;
import com.xzcode.product.common.entity.admin.AdminPermission;
import com.xzcode.product.common.entity.admin.AdminRole;
import com.xzcode.product.common.entity.admin.AdminRolePermission;
import com.xzcode.product.common.entity.admin.AdminUserRole;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 管理员角色 controller
 * 
 * @author zai & code generator
 * 2017-07-26 14:14:59
 */
@Controller
@RequestMapping(AdminRoleController.basePath)
public class AdminRoleController{
	
	public static final String basePath = "admin/adminrole";
	
	@Autowired
	private IAdminRoleService adminRoleService;
	
	@Autowired
	private IAdminPermissionService adminPermissionService;
	
	
	@Autowired
	private JdbcLink jdbcLink;

	
	@RequestMapping(value = "/view/list")
    public ModelAndView viewList(
    		HttpServletRequest request,
    		ModelAndView mav
    		){
		
		
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
				.select(AdminRole.class, "a")
					.column("a", "*")
				.where()
				
					.andGroup(StringUtils.isNotEmpty(keyword))
						.or().fuzzyLike("a", AdminRole.ROLE_NAME, keyword)
					.endGroup()
				
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
    @Transactional
    public AjaxResponse ajaxAddSave(AdminRole editObj, Long[] nodes) throws Exception{
    	/*
    	t.setCreateDate(new Date());
    	t.setCreateBy(SessionUtils.getAdmin().getUid());
    	t.setUpdateDate(t.getCreateDate());
    	t.setUpdateBy(SessionUtils.getAdmin().getUid());
    	*/
    	editObj.setCreateDate(new Date());
    	editObj.setCreateBy(SessionUtils.getUser().getUid());
    	
    	this.jdbcLink.insertSelective(editObj);
    	
    	AdminRolePermission adminRolePermission = null;
    	if (nodes.length > 0) {
    		for (Long permissionId : nodes) {
				
    			adminRolePermission = new AdminRolePermission();
    			adminRolePermission.setRoleId(editObj.getUid());
    			adminRolePermission.setPermissionId(permissionId);
    			this.jdbcLink.insert(adminRolePermission);
			}
			
		}
    	
    	
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/view/edit")
    public ModelAndView edit(ModelAndView mav, @RequestParam Long uid){
    
    	AdminRole editObj = this.jdbcLink.select(uid, AdminRole.class);
    	mav.addObject("editObj", editObj);
    	
    	List<AdminPermission> list = this.adminRoleService.getRolePermissions(uid);
    	
    	String nodes = list.stream().map(x -> String.valueOf(x.getUid())).collect(Collectors.joining(","));
    	mav.addObject("nodes", nodes);
    	
    	
    	mav.setViewName(basePath + "/edit");
    	return mav;
		
    }
    
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(AdminRole editObj, Long[] nodes){
    	
    	this.adminRoleService.updateRolePermission(editObj, nodes);
    	
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    public AjaxResponse ajaxDelete(@RequestParam Long uid){
    	//删除角色
    	this.jdbcLink.delete(uid, AdminRole.class);
    	//删除角色关用户关联
    	this.jdbcLink.delete(AdminUserRole.class).where().and().eq(AdminUserRole.ROLE_ID, uid).execute();
    	
    	//删除角色与权限关联
    	this.jdbcLink.delete(AdminRolePermission.class).where().and().eq(AdminRolePermission.ROLE_ID, uid).execute();
    	
    	
    	return AjaxResponse.success();
    }
    
    @RequestMapping(value = "/ajax/delete/flag")
    @ResponseBody
    public AjaxResponse ajaxDeleteFlag(
    		@RequestParam Long uid, 
    		Integer delFlag){
    	/*
    	this.jdbcLink.update(AdminRole.class)
    	.set()
    		.param(AdminRole.DEL_FLAG, AdminRole.TypeConstant.YES)
    	.where()
    		.and().eq(AdminRole.UID, uid)
		.execute();
		*/
    	return AjaxResponse.success();
		
    }
    
    @RequestMapping(value = "/ajax/get")
    @ResponseBody
    public AjaxResponse ajaxGet(
    		@RequestParam Long uid){
    	return AjaxResponse.success().setData(this.jdbcLink.select(uid, AdminRole.class));
    }
    
    @RequestMapping(value = "/view/show")
    public ModelAndView viewShow(
    		ModelAndView mav, 
    		@RequestParam Long uid
    		){
    	AdminRole showObj = this.jdbcLink.select(uid, AdminRole.class);
    	mav.addObject("showObj", showObj);
    	mav.setViewName(basePath + "/show");
    	return mav;
    }
	
	
}
