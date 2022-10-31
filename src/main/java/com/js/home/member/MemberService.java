package com.js.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception{
		
		return memberMapper.getMemberLogin(memberVO);
	}
	
	//사용자 정의 검증 메서드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		
		boolean check = false;
		//check = false : 검증성공(error 없음)
		//check = true : 검증실패(error 있음)
		
		//password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {		// pw와 pwCheck가 같지 않으면 true로 에러발생
			check = true;
		}
		
		return check;
	}
	
	
	public int setMemberJoin(MemberVO memberVO) throws Exception{
		
		return memberMapper.setMemberJoin(memberVO);
	}
	
	public Integer getIdCheck(MemberVO memberVO) throws Exception{
		
		return memberMapper.getIdCheck(memberVO);
	}
}
