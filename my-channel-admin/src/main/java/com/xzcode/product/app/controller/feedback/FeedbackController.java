package com.xzcode.product.app.controller.feedback;

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
import com.xzcode.product.app.service.facade.feedback.IFeedbackService;
import com.xzcode.product.app.utils.DataTablesResponseUtil;
import com.xzcode.product.common.entity.feedback.Feedback;
import com.xzcode.product.common.entity.user.UserInfo;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 用户反馈表 controller
 * 
 * @author zai & code generator
 * 2017-08-02 17:50:18
 */
@Controller
@RequestMapping(FeedbackController.basePath)
public class FeedbackController{
	
	public static final String basePath = "feedback/feedback";
	
	@Autowired
	private IFeedbackService feedbackService;
	
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
					.select(Feedback.class, "a")
					.column("a", "*")
					.column("u", UserInfo.USERNAME)
					
					.leftJoin(UserInfo.class, "u")
						.on().eq("u", UserInfo.UID, "a", Feedback.USER_ID)
					
					.where()
						.or(StringUtils.isNotEmpty(keyword)).fuzzyLike("a",Feedback.CONTENT, keyword)
						.or(StringUtils.isNotEmpty(keyword)).fuzzyLike("u",UserInfo.USERNAME, keyword)
						
					.orderBySorting(orderBy, sorting)
					//.orderByDesc("a", Feedback.CREATE_DATE)
					
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
    public AjaxResponse ajaxAddSave(Feedback editObj){
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
    
    	Feedback editObj = this.jdbcLink.select(uid, Feedback.class);
    	mav.addObject("editObj", editObj);
    	
    	UserInfo user = this.jdbcLink.select(editObj.getUserId(), UserInfo.class);
    	
    	mav.addObject("username", user.getUsername());
    	
    	mav.setViewName(basePath + "/edit");
    	return mav;
		
    }
    
    @RequestMapping(value = "/ajax/edit/save")
    @ResponseBody
    public AjaxResponse ajaxEditSave(Feedback editObj){
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
    	this.feedbackService.deleteByPrimaryKey(uid);
    	this.jdbcLink.delete(uid, Feedback.class);
    	return AjaxResponse.success();
    }
    
    @RequestMapping(value = "/ajax/delete/flag")
    @ResponseBody
    public AjaxResponse ajaxDeleteFlag(
    		@RequestParam Long uid, 
    		Integer delFlag){
    	/*
    	this.jdbcLink.update(Feedback.class)
    	.set()
    		.param(Feedback.DEL_FLAG, Feedback.TypeConstant.YES)
    	.where()
    		.and().eq(Feedback.UID, uid)
		.execute();
		*/
    	return AjaxResponse.success();
		
    }
    
    @RequestMapping(value = "/ajax/get")
    @ResponseBody
    public AjaxResponse ajaxGet(
    		@RequestParam Long uid){
    	return AjaxResponse.success().setData(this.jdbcLink.select(uid, Feedback.class));
    }
    
    @RequestMapping(value = "/view/show")
    public ModelAndView viewShow(
    		ModelAndView mav, 
    		@RequestParam Long uid
    		){
    	Feedback showObj = this.jdbcLink.select(uid, Feedback.class);
    	mav.addObject("showObj", showObj);
    	mav.setViewName(basePath + "/show");
    	return mav;
    }
	
	
}
