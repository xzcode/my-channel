package com.xzcode.product.app.controller.usercase;

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
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;
import com.xzcode.product.common.entity.info.Info;
import com.xzcode.product.common.entity.successful.SuccessfulCase;


@Controller
@RequestMapping("/usercase")
public class UsercaseController {
	
	@Autowired
	private JdbcLink jdbcLink;
	
	
	@RequestMapping("/user_case")
	public ModelAndView user_case(ModelAndView mav) {
		
		List<SuccessfulCase> list = this.jdbcLink.select(SuccessfulCase.class)
				.orderByDesc(Info.CREATE_DATE)
				.orderByDesc(SuccessfulCase.SORT)
				.queryList();
				
		mav.addObject("list", list);
		
		mav.setViewName("usercase/user_case");
		return mav;
	}
	
	@RequestMapping("/user_case_detail/{uid}")
	public ModelAndView user_case_detail(
			ModelAndView mav,
			@PathVariable("uid")
			Long uid
			) {
		mav.setViewName("usercase/user_case_detail");
		
		SuccessfulCase obj = this.jdbcLink.select(uid, SuccessfulCase.class);
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
		return this.jdbcLink.select(SuccessfulCase.class)
			.column(SuccessfulCase.UID)
			.column(SuccessfulCase.COVER_URL)
			.column(SuccessfulCase.TITLE)
			.orderByDesc(SuccessfulCase.HOT_NUM)
			.orderByDesc(SuccessfulCase.SORT)
			.orderByDesc(SuccessfulCase.CREATE_DATE)
			.limit(4)
			.queryListMap()
		;
	}

    
}
