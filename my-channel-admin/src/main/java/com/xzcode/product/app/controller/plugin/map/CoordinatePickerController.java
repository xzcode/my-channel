package com.xzcode.product.app.controller.plugin.map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(CoordinatePickerController.basePath)
public class CoordinatePickerController {
	public static final String basePath = "plugin/map/coordinate";
	
	
	
	@RequestMapping(value = "/view")
    public ModelAndView viewApplyList(
    		HttpServletRequest request,
    		ModelAndView mav
    		){
		
		
		mav.setViewName(basePath + "/coordinate_picker");
    	return mav;
    }
	
}
