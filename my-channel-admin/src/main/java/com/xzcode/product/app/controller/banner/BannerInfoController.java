package com.xzcode.product.app.controller.banner;

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
import com.xzcode.product.app.service.facade.banner.IBannerInfoService;
import com.xzcode.product.app.utils.DataTablesResponseUtil;
import com.xzcode.product.common.entity.banner.BannerInfo;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 轮播图信息表 controller
 * 
 * @author zai & code generator
 * 2017-08-02 17:50:18
 */
@Controller
@RequestMapping(BannerInfoController.basePath)
public class BannerInfoController{
	
		
	public static final String basePath = "banner/bannerinfo";
	
	@Autowired
	private IBannerInfoService bannerInfoService;
	
	
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
		//AdminUser adminUser = SessionUtils.getUser();
		
		
		
		
		Pager<Map<String, Object>> pager = 
				
			this.jdbcLink
				.select(BannerInfo.class, "a")
					.column("a", "*")
				
				.where()
					.or(StringUtils.isNotEmpty(keyword)).eq(BannerInfo.REMARK, keyword)
					
				.orderByDesc("a", BannerInfo.SORT)
				
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
					.select(BannerInfo.class, "a")
						.column("a", "*")
					
					.where()
						.andGroup()
							.or(StringUtils.isNotEmpty(keyword)).fuzzyLike(BannerInfo.REMARK, keyword)
							.or(StringUtils.isNotEmpty(keyword)).fuzzyLike(BannerInfo.LINK_URL, keyword)
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
    public AjaxResponse ajaxAddSave(BannerInfo editObj){
    	
    	editObj.setCreateDate(new Date());
    	
    	
    	this.jdbcLink.insertSelective(editObj);
    	if (editObj.getLinkType() == BannerInfo.LinkTypeConstant.CUSTOM) {
    		editObj.setLinkUrl("/banner/info/html/" + editObj.getUid());
    	}
    	
    	this.jdbcLink.update(editObj);
    	
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/view/edit")
    public ModelAndView edit(ModelAndView mav, @RequestParam Long uid){
    
    	Map<String, Object> editObj = this.jdbcLink
    			
		.select(BannerInfo.class, "a")
			.column("a", "*")
		.where()
			.and().eq("a", BannerInfo.UID, uid)
		.queryMap();
    	
    	
    	mav.addObject("editObj", editObj);
    	
    	mav.setViewName(basePath + "/edit");
    	return mav;
		
    }
    
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(BannerInfo editObj){
    	/*
    	editObj.setUpdateDate(new Date());
    	editObj.setUpdateBy(SessionUtils.getAdmin().getUid());
    	*/
    	if (editObj.getLinkType() == BannerInfo.LinkTypeConstant.CUSTOM) {
    		editObj.setLinkUrl("/banner/info/html/" + editObj.getUid());
    	}
    	this.jdbcLink.update(editObj);
    	return AjaxResponse.success();
    }
    
    
    @RequestMapping(value = "/ajax/delete")
    @ResponseBody
    public AjaxResponse ajaxDelete(@RequestParam Long uid){
    	this.jdbcLink.delete(uid, BannerInfo.class);
    	return AjaxResponse.success();
    }
    
    @RequestMapping(value = "/ajax/delete/flag")
    @ResponseBody
    public AjaxResponse ajaxDeleteFlag(
    		@RequestParam Long uid, 
    		Integer delFlag){
    	/*
    	this.jdbcLink.update(BannerInfo.class)
    	.set()
    		.param(BannerInfo.DEL_FLAG, BannerInfo.TypeConstant.YES)
    	.where()
    		.and().eq(BannerInfo.UID, uid)
		.execute();
		*/
    	return AjaxResponse.success();
		
    }
    
    @RequestMapping(value = "/ajax/get")
    @ResponseBody
    public AjaxResponse ajaxGet(
    		@RequestParam Long uid){
    	return AjaxResponse.success().setData(this.jdbcLink.select(uid, BannerInfo.class));
    }
    
    @RequestMapping(value = "/view/show")
    public ModelAndView viewShow(
    		ModelAndView mav, 
    		@RequestParam Long uid
    		){
    	BannerInfo showObj = this.jdbcLink.select(uid, BannerInfo.class);
    	mav.addObject("showObj", showObj);
    	mav.setViewName(basePath + "/show");
    	return mav;
    }
	
	
}
