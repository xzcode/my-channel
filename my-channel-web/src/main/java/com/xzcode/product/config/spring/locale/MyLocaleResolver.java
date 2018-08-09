package com.xzcode.product.config.spring.locale;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

public class MyLocaleResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		if (requestURI != null&& requestURI.startsWith("/en/")) {
			return Locale.ENGLISH;
		}
		return Locale.CHINESE;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		System.out.println(locale);

	}

}
