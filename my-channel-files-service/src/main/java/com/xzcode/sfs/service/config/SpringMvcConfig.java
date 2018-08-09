package com.xzcode.sfs.service.config;
import java.io.File;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.xzcode.sfs.service.filter.CORSFilter;
import com.xzcode.sfs.service.interceptor.RequestTimeInteceptor;


@Configuration
@ComponentScan(includeFilters={@Filter(classes=Controller.class)},basePackages={"com.xzcode.sfs.core.controller"})
public class SpringMvcConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
    private RequestMappingHandlerAdapter handlerAdapter;
	
	@Value("${server.tmpdir}")
	private String tmpDir;
	
	@Bean
	 MultipartConfigElement multipartConfigElement() {
	    MultipartConfigFactory factory = new MultipartConfigFactory();
	    
	    File dir = new File(this.tmpDir);
	    if (!dir.exists()) {
			dir.mkdirs();
		}else {
			if (dir.isFile()) {
				dir.delete();
			}
			dir.mkdirs();
		}
	    
	    String absolutePath = dir.getAbsolutePath();
	    factory.setLocation(absolutePath);
	    return factory.createMultipartConfig();
	}
	
	
	@PostConstruct
	public void init() {
		
		//添加日期转换工具
		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter
				.getWebBindingInitializer();
		if (initializer.getConversionService() != null) {
			GenericConversionService genericConversionService = (GenericConversionService) initializer
					.getConversionService();
			genericConversionService.addConverter(new StringToDateConverter());
		}
	}
	
	/**
	 * 跨域过滤器
	 * @return
	 * 
	 * @author zai
	 * 2017-08-09
	 */
	@Bean  
    public FilterRegistrationBean<CORSFilter> corsFilter() {
        FilterRegistrationBean<CORSFilter> registrationBean = new FilterRegistrationBean<>();  
        registrationBean.setFilter(new CORSFilter());  
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;  
    }  
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(requestTimeInteceptor());
	}
	
	public HandlerInterceptor requestTimeInteceptor(){
		String[] includePatterns = { "/**" };
		return new MappedInterceptor(includePatterns, new RequestTimeInteceptor());
	}
	

}
