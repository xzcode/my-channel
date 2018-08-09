package com.xzcode.product.app.controller.product;

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
import com.xzcode.product.common.entity.product.Product;
import com.xzcode.product.common.entity.product.ProductCategory;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private JdbcLink jdbcLink;
	
	
	@RequestMapping("/product_list")
	public ModelAndView index(ModelAndView mav) {
		
		List<Map<String, Object>> categories = 
				this.jdbcLink.select(ProductCategory.class,"a")
				.column("a", "*")
				.columnForSingleCol("products", ProductCategory.UID, Product.CATEGORY_ID, Product.class)
				.orderByAsc(ProductCategory.SORT)
				.queryListMap();
		mav.addObject("categories", categories);
		mav.setViewName("product/product_list");
		return mav;
	}
	
	@RequestMapping("/product_detail/{uid}")
	public ModelAndView product_detail(
			ModelAndView mav,
			@PathVariable("uid") Long uid
			) {
		if (uid == null) {
			mav.setViewName("error/404");
			return mav;
		}
		
		Product product = this.jdbcLink.select(uid, Product.class);
		if (product == null) {
			mav.setViewName("error/404");
			return mav;
		}
		
		String detailShowUrl = product.getDetailShowUrl();
		System.out.println(detailShowUrl.split(",").length);
		if (detailShowUrl != null) {
			mav.addObject("showPics", detailShowUrl.split(","));
		}
		
		mav.addObject("product", product);
		
		mav.setViewName("product/product_detail");
		return mav;
	}

    
}
