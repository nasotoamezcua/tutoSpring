package com.nasoto.tiendavirtual.web.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationUser {
	
	public static String authenticationUser(){
		
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		String user = aut.getName();
		return user;
	}

}
