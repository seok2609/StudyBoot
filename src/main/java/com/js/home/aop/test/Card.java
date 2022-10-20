package com.js.home.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class Card {
	
	@Before("execution(* com.js.home.aop.test.Transport.airPlane())")
		public void before() {
			log.info("------------before-----------");
		}
	
	
	@After("execution(* com.js.home.aop.test.Transport.get*())")
		public void after() {
			log.info("------------after-----------");
		
		}
	
	
	
	@Around(value ="execution(* com.js.home.aop.test.Transport.take*())")	//com.js.home.aop.test에 있는 Transeport에 get메서드 모든것
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		
		log.info("---- 삐삑 승차 입니다! ----");
		Object object = joinPoint.proceed();
		log.info("---- 삐빅 하차 입니다! ----");
		
		return object;
	}
	
//	@Around("execution(* com.js.home.aop.test.Transeport.take*())")
//	   public Object CardCheck(ProceedingJoinPoint joinPoint)throws Throwable{
//	      log.info("-----삐빅 승차입니다.------");
//	      Object obj = joinPoint.proceed();
//	      log.info("-----삐빅 하차입니다.------");
//	      
//	      return obj;
//	   }

}
