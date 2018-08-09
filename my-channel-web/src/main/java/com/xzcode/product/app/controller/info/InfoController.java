package com.xzcode.product.app.controller.info;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.jdbclink.core.models.Pager;
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;
import com.xzcode.product.common.entity.info.Info;
import com.xzcode.product.common.entity.successful.SuccessfulCase;


@Controller
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	private JdbcLink jdbcLink;
	

	
	@RequestMapping("/info_list")
	public ModelAndView info_list(
			ModelAndView mav, 
			@RequestParam(defaultValue = "1") Integer pageNo, 
			@RequestParam(defaultValue = "10") Integer pageSize
			) {
		mav.setViewName("info/info_list");
		
		Pager<Map<String, Object>> page = this.jdbcLink.select(Info.class)
				.column(Info.UID)
				.column(Info.TITLE)
				.column(Info.COVER_URL)
				.column(Info.CREATE_DATE)
				.column(Info.INTRO)
				
				.orderByDesc(Info.CREATE_DATE)
				.orderByDesc(Info.SORT)
				.limit(pageNo, pageSize)
				.pageListMap();
				
		mav.addObject("page", page);
		
		List<Map<String, Object>> hots = getHot();
		mav.addObject("hots", hots);
		
		return mav;
	}
	
	
	@RequestMapping("/info_detail/{uid}")
	public ModelAndView info_detail(
			ModelAndView mav,
			@PathVariable("uid")
			Long uid
			) {
		mav.setViewName("info/info_detail");
		
		Info obj = this.jdbcLink.select(uid, Info.class);
		if (obj == null) {
			mav.setViewName("error/404");
		}
		mav.addObject("obj", obj);
		
		List<Map<String, Object>> hots = getHot();
		mav.addObject("hots", hots);
		
		mav.addObject("seoTitle", obj.getSeoTitle());
		mav.addObject("seoKeywords", obj.getSeoKeywords());
		mav.addObject("seoDescription()", obj.getSeoDescription());
		
		return mav;
	}
	
	private List<Map<String, Object>> getHot() {
		return this.jdbcLink.select(Info.class)
			.column(Info.UID)
			.column(Info.COVER_URL)
			.column(Info.TITLE)
			.orderByDesc(Info.HOT_NUM)
			.orderByDesc(Info.SORT)
			.orderByDesc(Info.CREATE_DATE)
			.limit(5)
			.queryListMap()
		;
	}
	
    
}
