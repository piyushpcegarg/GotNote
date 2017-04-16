package com.gotprint.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	
	private static final long serialVersionUID = 4253144318713262815L;
	
	private long userId;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, long userId) {
		super(username, password, authorities);
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
}
