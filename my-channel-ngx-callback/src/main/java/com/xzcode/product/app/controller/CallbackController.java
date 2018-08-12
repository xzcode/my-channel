package com.xzcode.product.app.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.helper.CachedDataHelper;
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;
import com.xzcode.product.cache.CacheService;
import com.xzcode.product.common.entity.banner.BannerInfo;
import com.xzcode.product.common.entity.info.Info;
import com.xzcode.product.common.entity.product.ProductCategory;
import com.xzcode.product.common.entity.successful.SuccessfulCase;


@Controller
@RequestMapping("callback")
public class CallbackController {
	
	@Autowired
	private JdbcLink jdbcLink;
	
	@Autowired
	private CacheService cacheService;
	
	@Autowired
	private CachedDataHelper cachedDataHelper;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Autowired
	private IAdminPermissionService adminPermissionService;
	
	
	@RequestMapping("/on_publish")
	public void on_publish(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("on_publish:" + request.getRequestURI());
		showParams(request);
		response.setStatus(200);
	}
	
	@RequestMapping("/on_play")
	public void on_play(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("on_play:" + request.getRequestURI());
		showParams(request);
		response.setStatus(200);
	}
	
	@RequestMapping("/on_play_done")
	public void on_play_done(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("on_play_done:" + request.getRequestURI());
		showParams(request);
		response.setStatus(200);
	}
	
	@RequestMapping("/on_connect")
	public void on_connect(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("on_connect :" + request.getRequestURI());
		showParams(request);
		response.setStatus(200);
	}
	
	@RequestMapping("/on_publish_done")
	public void on_publish_done(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("on_publish_done :" + request.getRequestURI());
		showParams(request);
		response.setStatus(200);
	}
	
	@RequestMapping("/on_record_done")
	public void on_record_done(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("on_record_done :" + request.getRequestURI());
		showParams(request);
		response.setStatus(200);
	}
	
	@RequestMapping("/on_update")
	public void on_update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("on_update :" + request.getRequestURI());
		showParams(request);
		response.setStatus(200);
	}
	
	
	
	
	private void showParams(HttpServletRequest request) {
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (String key : parameterMap.keySet()) {
			String[] arr = parameterMap.get(key);
			System.out.println(key +":"+Arrays.asList(arr));
		}
	}
}
