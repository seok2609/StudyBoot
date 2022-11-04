package com.js.home.member.sercurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccess implements AuthenticationSuccessHandler{

	
	//이 메서드는 로그인이 성공했을떄 실행됌
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.info("======================로그인 성공===================");
		log.info("Auth ====>> {} ", authentication);
		log.info("ID : {} ", request.getParameter("id"));
		
		String check = request.getParameter("rememberId");
		
		log.info("Check : {} " , check);
		
		if(check != null && check.equals("on")) { 	//check.equals("on")만쓰면 체크를 안할시에 null이 들어가서 널포인트 익셉션 발생함
			
			Cookie cookie = new Cookie("userId", request.getParameter("id"));
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60);		//초 단위임
			cookie.setPath("/");		//같은 도메인 내에서 어느 URL에서 사용 가능한가 적용

			response.addCookie(cookie);
			
		}else {
			
			Cookie [] cks = request.getCookies();
			for(Cookie cookie : cks) {
				
				if(cookie.getName().equals("userId")){
					cookie.setMaxAge(0);
					cookie.setPath("/");	// 쿠키 생성시와 같은 도메인 영역에서만 지워짐
					response.addCookie(cookie);
					log.info("===========쿠키삭제=========");
					break;
				}
			}
		
			
		}
		response.sendRedirect("/");
	}

}
