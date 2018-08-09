package com.xzcode.product.config.security.springsecurity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.xzcode.jdbclink.core.JdbcLink;
import com.xzcode.product.common.entity.admin.AdminPermission;
import com.xzcode.product.common.entity.admin.AdminRole;
import com.xzcode.product.common.entity.admin.AdminRolePermission;
import com.xzcode.product.common.entity.admin.AdminUser;
import com.xzcode.product.common.entity.admin.AdminUserRole;


@Component
public class ScUserDetailsService implements UserDetailsService{
	
	@Autowired
	private JdbcLink jdbcLink;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null) {
			throw new UsernameNotFoundException("Username can not be null!");
		}
		AdminUser adminUser = jdbcLink.select(AdminUser.class)
				.where()
					.and().eq(AdminUser.USERNAME, username)
				.queryEntity();
		if (adminUser == null) {
			throw new UsernameNotFoundException("Username not found!");
		}
		
		
		List<AdminPermission> authorityEntities = this.jdbcLink.select(AdminPermission.class, "ar")
		
		.column("ap", "*")
		
		.join(AdminUserRole.class, "aur")
			.on().eq("aur", AdminUserRole.ROLE_ID, "ar", AdminRole.UID)
			
		.join(AdminUser.class, "au")
			.on().eq("au", AdminUser.UID, "aur", AdminUserRole.USER_ID)
			.and().eq("au", AdminUser.UID, adminUser.getUid())
			
		.join(AdminRolePermission.class, "arp")
			.on().eq("arp", AdminRolePermission.ROLE_ID, "ar", AdminRole.UID)
			
		.join(AdminPermission.class, "ap")
			.on().eq("ap", AdminPermission.UID, "arp", AdminRolePermission.PERMISSION_ID)
			
		.orderByAsc("ap", AdminPermission.SORT_ORDER)
		.queryList()
		;
		List<ScGrantedAuthority> authorities = null;
		
		if (authorityEntities != null) {
			authorities = authorityEntities.stream().map( o -> {
				return new ScGrantedAuthority(o.getPermissionName());
			}).collect(Collectors.toList());
		}
		
		ScUserDetails userDetails = new ScUserDetails(
				adminUser.getUsername(), 
				adminUser.getPassword(), 
				adminUser.getEnabled() == 1 ? true : false, 
						true, 
						true, 
						true,
						authorities, 
						adminUser
						);
		return userDetails;
	}

}
