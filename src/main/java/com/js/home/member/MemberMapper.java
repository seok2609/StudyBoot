package com.js.home.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;
	
	public int setMemberJoin(MemberVO memberVO) throws Exception;
	
	public int getIdCheck(String id) throws Exception;
	
}
