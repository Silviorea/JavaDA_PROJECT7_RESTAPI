package com.nnk.springboot.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import com.nimbusds.jose.proc.SecurityContext;

public class AuthUsername
{
	public String getUsername()
	{
		Object u = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (u instanceof DefaultOAuth2User)
		{
			DefaultOAuth2User user = (DefaultOAuth2User) u;
			return user.getAttributes().get("login").toString();
		}
		
		User user = (User) u;
		return user.getUsername();
	}
}
