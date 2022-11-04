package com.js.home.member.sercurity;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginFail implements AuthenticationFailureHandler{
	
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		log.info("=====Login Fail=======");
        log.info("ClassName => {}", exception.getClass().toString());
        log.info("LocalMessage => {}", exception.getLocalizedMessage());
        log.info("Cause = {}", exception.getCause());
        log.info("Message => {}", exception.getMessage());
//        String name = exception.getClass().toString();
//        name = name.substring(name.lastIndexOf(".")+1);
//        if(name.equals("BadCredentialsException")) {
//           name = "비밀번호 틀림";
//        }
        
        String result = null;
        // 참조변수명 instanceof 클래스명
        if(exception instanceof BadCredentialsException) {
        	result = "비번 틀림";
        }else if(exception instanceof InternalAuthenticationServiceException){
        	result = "아이디 없음";
        }else {
        	result = "로그인 실패";
        }
        
        //redirect 방법
        result = URLEncoder.encode(result, "UTF-8");
        response.sendRedirect("/member/login?error=true&message=" + result);
        
        //jsp로 foward 형식으로 보냄
//        request.setAttribute("msg", result);
//        request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
		
        //POST 방식으로 Controller의 메서드를 요청함
//        request.setAttribute("msg", result);
//        request.getRequestDispatcher("/member/login?message="+result).forward(request, response);
		
	}

}
