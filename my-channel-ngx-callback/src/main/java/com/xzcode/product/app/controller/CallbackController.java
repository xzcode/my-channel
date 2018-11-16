package com.xzcode.product.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.app.helper.CachedDataHelper;
import com.xzcode.product.app.service.facade.admin.IAdminPermissionService;
import com.xzcode.product.cache.CacheService;


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
	
	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	@RequestMapping("/on_publish")
	public void on_publish(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("on_publish:" + request.getRequestURI());
		showParams(request);
		ListenableFuture send = kafkaTemplate.send("logs", "hello world - " + new Date());
		try {
			System.out.println(send.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
