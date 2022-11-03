package com.js.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberSecurityService  implements UserDetailsService{

	@Autowired
	private MemberMapper memberMapper;
	
	
	@Override
	//UserDetails 에는 인가정보가 들어있다.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MemberVO memberVO = new MemberVO();
		
		log.info("=============로그인 시도중===========");
		memberVO = memberMapper.getMemberLogin(username);
		log.info("MemberVO : {} ", memberVO);
		
		
		return memberVO;
	}
	
	

}
