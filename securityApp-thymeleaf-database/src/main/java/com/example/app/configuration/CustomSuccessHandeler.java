package com.example.app.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandeler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String REDIRECT_URL = (String) request.getSession().getAttribute("REDIRECT_URL");
		if (REDIRECT_URL != null) {
			response.sendRedirect(REDIRECT_URL);
			return;
		}
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			
			if (authority.getAuthority().equals("ROLE_ADMIN"))
				REDIRECT_URL = "/admin";
			
			else if (authority.getAuthority().equals("ROLE_DBA"))
				REDIRECT_URL = "/dba";
			
			else if (authority.getAuthority().equals("ROLE_USER"))
				REDIRECT_URL = "/user";
			
			else
				REDIRECT_URL = "/";
			
		}
		response.sendRedirect(REDIRECT_URL);
	}

}
