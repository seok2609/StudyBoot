package com.js.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface MemberMapper {

	public MemberVO getMemberLogin(String username) throws UsernameNotFoundException;
	
	public int setMemberJoin(MemberVO memberVO) throws Exception;
	
	public Integer getIdCheck(MemberVO memberVO) throws Exception;
	
}
