package com.js.home.member.sercurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class LogoutCustom implements LogoutHandler{

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		
		request.getSession().invalidate();
		
		log.info("======================LogoutHandler====================");
	}

}
