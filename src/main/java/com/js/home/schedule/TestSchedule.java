package com.js.home.schedule;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.js.home.member.MemberMapper;
import com.js.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestSchedule {

	
	@Autowired
	private MemberMapper memberMapper;
	
	@Scheduled(cron = "30 * * * * *")
	public void cron() throws Exception{
		log.info("Cron 매초 실행");
		log.info(Calendar.getInstance().getTime().toString());	//현재시간
		
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("AutoID"+Calendar.getInstance().getTimeInMillis());	//id는 pk라 중복되면 안되기때문에 현재시간을 Long타입으로 변환해서 set
		memberVO.setPw("123");
		memberVO.setName("Name");
		memberVO.setEmail("Email");
		log.info("Result : {} ", memberMapper.setMemberJoin(memberVO)); 
	}
	
	//@Scheduled(fixedRate = 3000, initialDelayString = "1000" )	//3초 주기  fixedRate의 단위는 밀리세컨즈
	public void ts1() {
		log.info("Schedule 실행");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
