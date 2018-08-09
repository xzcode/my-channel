package ${controllerPackageName};

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ${packageGroupName}.product.app.utils.DataTablesResponseUtil;
import ${packageGroupName}.product.app.model.datatables.DataTablesResponse;
import ${packageGroupName}.product.common.util.AjaxResponse;
import ${fullEntityClassName};
import ${packageGroupName}.jdbclink.core.JdbcLink;
import ${packageGroupName}.jdbclink.core.models.Pager;
import ${fullServiceInterfaceName};
import org.apache.commons.lang3.StringUtils;
import ${packageGroupName}.product.app.utils.SessionUtils;
<#if hasUserId>
import ${packageGroupName}.product.common.entity.user.UserInfo;
</#if>
<#if hasAdminId>
import ${packageGroupName}.product.common.entity.admin.AdminUser;
</#if>

/**
 * ${tableDesc} controller
 * 
 * @author ${author}
 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@Controller
@RequestMapping(${entityClassName}Controller.basePath)
public class ${entityClassName}Controller{

	private static final Logger logger = LoggerFactory.getLogger(${entityClassName}Controller.class);
	
	public static final String basePath = "${packageModelName}/${entityClassName?lower_case}";
	
	@Autowired
	private ${serviceInterfaceName} ${serviceName?uncap_first};
	
	@Autowired
	private JdbcLink jdbcLink;
	
	
	/**
	 * 视图
	 * @param request
	 * @param mav
	 * @return
	 * 
	 * @author ${author}
	 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
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
	 * @author ${author}
	 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
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
    		<#if hasEnabled>
    		Integer enabled,
    		</#if>
    		String keyword
    		){
		
		Pager<Map<String, Object>> pager = 
				
		this.jdbcLink
			.select(${entityClassName}.class, "a")
				.column("a", "*")
				<#if hasUserId>
				.column("u", UserInfo.USERNAME)
				.column("u", UserInfo.MOBILE)
				</#if>
				<#if hasAdminId>
				.column("au", AdminUser.REALNAME, "adminName")
				</#if>
				
			<#if hasUserId>	
			.leftJoin(UserInfo.class, "u")
				.on().eq("u", UserInfo.UID, "a", ${entityClassName}.USER_ID)
			<#else>
			/*
			.leftJoin(UserInfo.class, "u")
				.on().eq("u", UserInfo.UID, "a", ${entityClassName}.USER_ID)
			*/
			</#if>
			
			<#if hasAdminId>	
			.leftJoin(AdminUser.class, "au")
				.on().eq("au", AdminUser.UID, "a", ${entityClassName}.ADMIN_ID)
			</#if>
			
				
			.where()
				.andGroup()
				<#if hasUserId>	
						.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("u", UserInfo.MOBILE, keyword)
						.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("u", UserInfo.USERNAME, keyword)
				<#else>
				/*
						.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("u", UserInfo.MOBILE, keyword)
						.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("u", UserInfo.USERNAME, keyword)
				*/
				</#if>
				<#if hasAdminId>	
						.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("au", AdminUser.REALNAME, keyword)
				</#if>
				.endGroup()
			
			<#if hasEnabled>	
			.and(enabled != null).eq("a", ${entityClassName}.ENABLED, enabled)
			</#if>	
			
				
			.orderBySorting(orderBy, sorting)
			
			.limitStarts(start, pageSize)
			.pageListMap();
		
    	return DataTablesResponseUtil.parse(pager, draw);
    }
    
    /**
	 * id获取实体Map
	 * 
	 * @author ${author}
	 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
    private Map<String, Object> queryEntityMap(Long uid) {
    
    	return this.jdbcLink
			.select(${entityClassName}.class, "a")
				.column("a", "*")
				<#if hasUserId>
				.column("u", UserInfo.USERNAME)
				.column("u", UserInfo.MOBILE)
				</#if>
				<#if hasAdminId>
				.column("au", AdminUser.REALNAME, "adminName")
				</#if>
				
			<#if hasUserId>	
			.leftJoin(UserInfo.class, "u")
				.on().eq("u", UserInfo.UID, "a", ${entityClassName}.USER_ID)
			<#else>
			/*	
			.leftJoin(UserInfo.class, "u")
				.on().eq("u", UserInfo.UID, "a", ${entityClassName}.USER_ID)
			*/
			</#if>
			<#if hasAdminId>	
			.leftJoin(AdminUser.class, "au")
				.on().eq("au", AdminUser.UID, "a", ${entityClassName}.ADMIN_ID)
			</#if>
			
			.where()
				.and().eq("a", ${entityClassName}.UID, uid)
			.queryMap();
    
    }

    /**
	 * 数据展示视图
	 * 
	 * @author ${author}
	 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
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
	 * @author ${author}
	 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
    @RequestMapping(value = "/view/add")
    public ModelAndView viewAdd(ModelAndView mav){
    	mav.setViewName(basePath + "/add");
    	return mav;
    }
    
    /**
	 * ajax数据实体保存请求
	 * 
	 * @author ${author}
	 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
    @RequestMapping(value = "/ajax/add/save")
    @ResponseBody
    public AjaxResponse ajaxAddSave(${entityClassName} editObj){
    	<#if hasCreateDate>
    	editObj.setCreateDate(new Date());
    	</#if>
    	<#if hasAdminId>
    	editObj.setAdminId(SessionUtils.getUser().getUid());
    	</#if>
    	this.jdbcLink.insert(editObj);
    	return AjaxResponse.success();
    }
    
    /**
	 * 数据编辑视图
	 * 
	 * @author ${author}
	 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
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
	 * @author ${author}
	 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(${entityClassName} editObj){
    	this.jdbcLink.update(editObj);
    	return AjaxResponse.success();
    }
    
    /**
	 * 删除或失效数据
	 * 
	 * @author ${author}
	 * ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    public AjaxResponse ajaxDelete(
    	@RequestParam Long uid,
		Optional<Integer> statusValue
    ){
    	/*
    	this.jdbcLink.delete(uid, ${entityClassName}.class);
		*/
	<#if hasEnabled>
    	this.jdbcLink.update(${entityClassName}.class)
    	.set()
    		.param(${entityClassName}.ENABLED, statusValue.orElse(${entityClassName}.EnabledConstant.NO))
    	.where()
    		.and().eq(${entityClassName}.UID, uid)
		.execute();
	</#if>
    	
    	return AjaxResponse.success();
    }
	
}
