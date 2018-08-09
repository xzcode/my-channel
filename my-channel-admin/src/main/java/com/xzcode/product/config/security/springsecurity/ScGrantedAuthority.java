package com.xzcode.product.config.security.springsecurity;

import org.springframework.security.core.GrantedAuthority;

public class ScGrantedAuthority implements GrantedAuthority {
	
	private static final long serialVersionUID = -4828597802632158543L;
	
	
	private String authority;
	
	

	public ScGrantedAuthority(String authority) {
		super();
		this.authority = authority;
	}


	@Override
	public String getAuthority() {
		return authority;
	}

}
