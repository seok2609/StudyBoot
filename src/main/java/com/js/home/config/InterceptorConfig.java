package com.js.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.js.home.interceptors.StudyInterceptor;
import com.js.home.interceptors.Testinterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private Testinterceptor testinterceptor;
	@Autowired
	private StudyInterceptor studyInterceptor;
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
		public void addInterceptors(InterceptorRegistry registry) {
			
			//method 체이닝 메서드를 끊임없이 이어주는 역할
			//적용할 Interceptor 등록
			registry.addInterceptor(testinterceptor)
			//Interceptor를 적용할 URL 등록
					.addPathPatterns("/qna/**")
					.addPathPatterns("/notice/**")
					
			//제외할 URL을 등록
					.excludePathPatterns("/qna/detail")
					.excludePathPatterns("/qna/write");
			
			//추가 Interceptor 등록
			registry.addInterceptor(studyInterceptor)
					.addPathPatterns("/qna/**");
			
			
			registry.addInterceptor(localeChangeInterceptor)
					.addPathPatterns("/**");
			
		
			//WebMvcConfigurer.super.addInterceptors(registry);
		}
}
