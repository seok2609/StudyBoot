package com.js.home.aop.test;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Transport {
	
	public void takeBus() {
		

		log.info("------------------버스 타기------------------");
	
	}
	
	public void takeSubway() {
		

		log.info("------------------쟈철 타기------------------");

	}
	
	public void getTaxi() {
		
		log.info("------------------택시 타기-------------------");
	}
	
	
	public void airPlane() {
		
		log.info("------------------뱽기 타기--------------------");
	}

}
