package com.xzcode.product.app.controller.product;

import java.util.Date;
import java.util.List;
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
import com.xzcode.product.app.utils.DataTablesResponseUtil;
import com.xzcode.product.app.model.datatables.DataTablesResponse;
import com.xzcode.product.common.util.AjaxResponse;
import com.xzcode.product.common.entity.product.Product;
import com.xzcode.product.common.entity.product.ProductCategory;
import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.jdbclink.core.models.Pager;
import com.xzcode.product.app.service.facade.product.IProductService;
import org.apache.commons.lang3.StringUtils;
import com.xzcode.product.app.utils.SessionUtils;
import com.xzcode.product.common.entity.admin.AdminUser;

/**
 * 行业资讯信息表 controller
 * 
 * @author jdbclink code generator
 * 2018-06-27 23:00:44
 */
@Controller
@RequestMapping(ProductController.basePath)
public class ProductController{

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	public static final String basePath = "product/product";
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private JdbcLink jdbcLink;
	
	
	/**
	 * 视图
	 * @param request
	 * @param mav
	 * @return
	 * 
	 * @author jdbclink code generator
	 * 2018-06-27 23:00:44
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
	 * 2018-06-27 23:00:44
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
    		Integer enabled,
    		String keyword
    		){
		
		Pager<Map<String, Object>> pager = 
				
		this.jdbcLink
			.select(Product.class, "a")
				.column("a", "*")
				.column("au", AdminUser.REALNAME, "adminName")
				
			
			.leftJoin(AdminUser.class, "au")
				.on().eq("au", AdminUser.UID, "a", Product.ADMIN_ID)
			
				
			.where()
				.andGroup()
					.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("a", Product.COVER_TITLE, keyword)
					.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("a", Product.CATEGORY_NAME, keyword)
					.or(StringUtils.isNoneEmpty(keyword)).fuzzyLike("au", AdminUser.REALNAME, keyword)
				.endGroup()
			
			.and(enabled != null).eq("a", Product.ENABLED, enabled)
			
				
			.orderBySorting(orderBy, sorting)
			
			.limitStarts(start, pageSize)
			.pageListMap();
		
    	return DataTablesResponseUtil.parse(pager, draw);
    }
    
    /**
	 * id获取实体Map
	 * 
	 * @author jdbclink code generator
	 * 2018-06-27 23:00:44
	 */
    private Map<String, Object> queryEntityMap(Long uid) {
    
    	return this.jdbcLink
			.select(Product.class, "a")
				.column("a", "*")
				.column("au", AdminUser.REALNAME, "adminName")
				
			/*	
			.leftJoin(UserInfo.class, "u")
				.on().eq("u", UserInfo.UID, "a", Product.USER_ID)
			*/
			.leftJoin(AdminUser.class, "au")
				.on().eq("au", AdminUser.UID, "a", Product.ADMIN_ID)
			
			.where()
				.and().eq("a", Product.UID, uid)
			.queryMap();
    
    }

    /**
	 * 数据展示视图
	 * 
	 * @author jdbclink code generator
	 * 2018-06-27 23:00:44
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
	 * 2018-06-27 23:00:44
	 */
    @RequestMapping(value = "/view/add")
    public ModelAndView viewAdd(ModelAndView mav){
    	List<ProductCategory> categories = getCategories();
    	mav.addObject("categories", categories);
    	mav.setViewName(basePath + "/add");
    	return mav;
    }
    
    /**
     * 获取分类列表
     * @return
     * 
     * @author zai
     * 2018-07-04 13:23:49
     */
    private List<ProductCategory> getCategories() {
    	return this.jdbcLink.select(ProductCategory.class).orderByAsc(ProductCategory.SORT).queryList();
    }
    
    
    /**
	 * ajax数据实体保存请求
	 * 
	 * @author jdbclink code generator
	 * 2018-06-27 23:00:44
	 */
    @RequestMapping(value = "/ajax/add/save")
    @ResponseBody
    public AjaxResponse ajaxAddSave(Product editObj){
    	editObj.setCreateDate(new Date());
    	editObj.setAdminId(SessionUtils.getUser().getUid());
    	
    	Long categoryId = editObj.getCategoryId();
    	if (categoryId != null) {
			ProductCategory productCategory = this.jdbcLink.select(categoryId, ProductCategory.class);
			editObj.setCategoryName(productCategory.getName());				
		}
    	
    	this.jdbcLink.insert(editObj);
    	return AjaxResponse.success();
    }
    
    /**
	 * 数据编辑视图
	 * 
	 * @author jdbclink code generator
	 * 2018-06-27 23:00:44
	 */
    @RequestMapping(value = "/view/edit")
    public ModelAndView edit(ModelAndView mav, @RequestParam Long uid){
    
    	Map<String, Object> editObj = queryEntityMap(uid);
    	mav.addObject("editObj", editObj);
    	
    	List<ProductCategory> categories = getCategories();
    	mav.addObject("categories", categories);
    	
    	mav.setViewName(basePath + "/edit");
    	return mav;
		
    }
    
    /**
	 * ajax实体编辑保存
	 * 
	 * @author jdbclink code generator
	 * 2018-06-27 23:00:44
	 */
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(Product editObj){
    	
    	Long categoryId = editObj.getCategoryId();
    	if (categoryId != null) {
			ProductCategory productCategory = this.jdbcLink.select(categoryId, ProductCategory.class);
			editObj.setCategoryName(productCategory.getName());				
		}
    	
    	this.jdbcLink.update(editObj);
    	return AjaxResponse.success();
    }
    
    /**
	 * 删除或失效数据
	 * 
	 * @author jdbclink code generator
	 * 2018-06-27 23:00:44
	 */
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    public AjaxResponse ajaxDelete(
    	@RequestParam Long uid,
		Optional<Integer> statusValue
    ){
    	/*
    	this.jdbcLink.delete(uid, Product.class);
		*/
    	this.jdbcLink.update(Product.class)
    	.set()
    		.param(Product.ENABLED, statusValue.orElse(Product.EnabledConstant.NO))
    	.where()
    		.and().eq(Product.UID, uid)
		.execute();
    	
    	return AjaxResponse.success();
    }
	
}
