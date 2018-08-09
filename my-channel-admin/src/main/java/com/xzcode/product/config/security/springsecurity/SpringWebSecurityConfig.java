package com.xzcode.product.config.security.springsecurity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.google.gson.Gson;
import com.xzcode.product.common.util.AjaxResponse;

/**
 * 
 * Spring Security 配置类
 * 
 * @author zai
 * 2018-03-29
 */
@Configuration
@EnableWebSecurity
//@DependsOn("springMVCConfig")//必须先依赖启动webmvc容器
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	
	@Autowired
	private ScUserDetailsService scUserDetailsService;
	
	private Gson gson = new Gson();
	
	
	

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.antMatchers(
					"/plugins/**",
					"/fonts/**",
					"/css/**",
					"/js/**",
					"/images/**"
					
					);
	}

	/**
	 * 密码加密与校验器
	 * @return
	 * 
	 * @author zai
	 * 2018-05-08
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return encodedPassword.equals(rawPassword);
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		};
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			
			.authorizeRequests()
				//.antMatchers("/login/submit").permitAll()
				.anyRequest().fullyAuthenticated()
			.and()
				.formLogin()
					.loginPage("/login.html")
					
					.usernameParameter("username")
					.passwordParameter("password")
					
					//登录处理
					.loginProcessingUrl("/login/submit")
					//登录成功
					//.successForwardUrl("/index.html")
					.successHandler(getAuthenticationSuccessHandler())
					//登录失败
					.failureHandler(getAuthenticationFailureHandler())
					.permitAll()
			
			.and()
				
				.logout()
				.logoutUrl("/logout")
				.permitAll()
			.and().headers().frameOptions().disable()
			.and().csrf().disable()
			
				;
	}
	
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(scUserDetailsService);
		
	}
	
	/**
	 * 登录成功处理
	 * @return
	 * 
	 * @author zai
	 * 2018-03-29
	 */
	private AuthenticationSuccessHandler getAuthenticationSuccessHandler() {
		return new AuthenticationSuccessHandler() {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response,Authentication authentication) throws IOException, ServletException {
					Gson gson = new Gson();
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter()
						.write(gson.toJson(
							AjaxResponse.success().setMessage("登陆成功!")
					));
			}
		};
	}
	
	/**
	 * 登录失败处理
	 * @return
	 * 
	 * @author zai
	 * 2018-03-29
	 */
	private AuthenticationFailureHandler getAuthenticationFailureHandler() {
		return new AuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				PrintWriter writer = response.getWriter();
				
				if (exception instanceof DisabledException) {
					writer.write(gson.toJson(AjaxResponse.fail().setMessage("帐号已禁用!")));
					
				}else if (exception instanceof UsernameNotFoundException){
					writer.write(gson.toJson(AjaxResponse.fail().setMessage("用户名不存在!")));
					
				}else if (exception instanceof BadCredentialsException){
					writer.write(gson.toJson(AjaxResponse.fail().setMessage("用户名或密码错误!")));
					
				}else {
					writer.write(gson.toJson(AjaxResponse.fail().setMessage("登陆失败!")));
				}
				
				
			}
		};
	}

	
	
}
