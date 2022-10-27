package com.js.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		
		return memberMapper.getMemberLogin(memberVO);
	}
	
	public int setMemberJoin(MemberVO memberVO) throws Exception{
		
		return memberMapper.setMemberJoin(memberVO);
	}
	
	public Integer getIdCheck(MemberVO memberVO) throws Exception{
		
		return memberMapper.getIdCheck(memberVO);
	}
}
