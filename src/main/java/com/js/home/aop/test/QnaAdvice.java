package com.js.home.aop.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.js.home.board.qna.QnaVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class QnaAdvice {
	
	@After("execution(* com.js.home.board.qna.QnaService.get*(..))")
	public void beforeTest(JoinPoint joinpoint) throws Throwable{
		log.info("========== AFTER ==========");
		log.info("Args : {} ", joinpoint.getArgs());
		log.info("kind : {} ", joinpoint.getKind());
		
	}
	
	@Around("execution(* com.js.home.board.qna.QnaService.set*(..))")
	public Object aroundTest(ProceedingJoinPoint joinPoint) throws Throwable{
		
		log.info("======================= BEFORE ===========================");
		//point-cut 의 클래스 객체
		log.info("Target : {} ", joinPoint.getTarget());
		//point-cut 의 클래스 객체
		log.info("This : {} ", joinPoint.getThis());
		//point-cut 으로 전달되는 매개변수의 인자값
		log.info("Args : {} ", joinPoint.getArgs());
		
		
		log.info("Class : {} ", joinPoint.getClass());
		log.info("Kind : {} ", joinPoint.getKind());
		
		Object [] objects = joinPoint.getArgs();
		QnaVO qnaVO = (QnaVO)objects[0];	//다형성 (형변환)
		
		Object object = joinPoint.proceed();
		
		log.info("======================= AFTER ===========================");
		log.info("Object : {} " , object);
		
		
		
		return object;
	}

}
