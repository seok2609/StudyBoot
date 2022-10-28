package com.js.home.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageConfig implements WebMvcConfigurer{
	
	//@Bean = 라이브러리로 받은 클래스의 객체를 만들때 사용
	
	@Bean
	public LocaleResolver local() {
		
		//1. session
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.KOREAN);
		
		
		//2. Cookie
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);	//기본위치를 어디로 할거냐
		cookieLocaleResolver.setCookieName("lang");		//파라미터를 어떻게 보낼꺼냐
		
//		return sessionLocaleResolver;
		return cookieLocaleResolver;
	}
	
	//Interceptor 객체
	@Bean
	public LocaleChangeInterceptor changeInterceptor() {
		
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("lang");	//파라미터 이름을 뭐로 할꺼냐
		
		//파라미터를 받아서 언어 구분
		//url?lang=ko
		return changeInterceptor;
		
	}
	
	
	
	// ***-context.xml
	// 라이브러리에 있는 클래스를 선언할때 new를 쓴다 왜? 어노테이션에 없을 수 있기 때문에~
	// <bean class="" id=""> == new 생성자() 	
	//@Bean 을 주면 sts3에 servlet.context 에 있는  <bean class="" id="">와 같은 역할을 함 
	
//	@Bean
//	public String getString() {
//		
//		return new String();
//	}
	
	
}
