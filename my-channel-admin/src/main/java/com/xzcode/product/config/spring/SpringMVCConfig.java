package com.xzcode.product.config.spring;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xzcode.product.app.interceptor.RequestTimeInteceptor;
import com.xzcode.product.config.spring.converter.StringToDateConverter;

/**
 * web配置
 * 
 * 
 * @author zai
 * 2018-05-17
 */
@Configuration
public class SpringMVCConfig extends WebMvcConfigurationSupport{
	
	
	/**
	 * 添加自定义的Converters和Formatters.
	 */
	@Override
	protected void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToDateConverter());
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestTimeInteceptor());
	}


	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
	}


	@Override
	protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd HH:mm:ss")
				.serializeNulls()
				.create();
		GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter(gson );
		converters.add(0, gsonHttpMessageConverter);
	}


	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		//super.addResourceHandlers(registry);
		
		registry.addResourceHandler(
				"/plugins/**",
				"/fonts/**",
				"/css/**",
				"/js/**",
				"/images/**"
				)
		.addResourceLocations(
				"classpath:/static/plugins/",
				"classpath:/static/fonts/",
				"classpath:/static/css/",
				"classpath:/static/js/",
				"classpath:/static/images/"
				)
		;
		
		//适配swagger
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		
		
	}
	

}
