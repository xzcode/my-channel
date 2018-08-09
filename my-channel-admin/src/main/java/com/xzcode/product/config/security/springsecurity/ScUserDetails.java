package com.xzcode.product.config.security.springsecurity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.xzcode.product.common.entity.admin.AdminUser;

public class ScUserDetails extends User{
	
	private static final long serialVersionUID = -9099214982131837576L;
	
	private Object userEntity;

	
	public ScUserDetails(
			String username, 
			String password, 
			boolean enabled, 
			boolean accountNonExpired,
			boolean credentialsNonExpired, 
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			AdminUser adminUser
			) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.userEntity = adminUser;
	}
	

	public Object getUserEntity() {
		return this.userEntity;
	}
	
	public void setUserEntity(Object userEntity) {
		this.userEntity = userEntity;
	}

}
