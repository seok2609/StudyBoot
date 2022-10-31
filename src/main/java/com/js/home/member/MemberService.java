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
		
		//1. Annotation검증
		check = bindingResult.hasErrors();
		
		//2. password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {		// pw와 pwCheck가 같지 않으면 true로 에러발생
			check = true;
			//에러메시지
//			bindingResult.rejectValue("멤버변수명(path)", "properties의 key(코드)");
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
		}
		
		//3. Id가 중복인지 검증
		
		int result = memberMapper.getIdCheck(memberVO);
		
		//result가 0보다 크면 에러발생(중복)
		//result가 0이면 중복없음 - 통과 
		
		if(result > 0) {
			check = true;
			bindingResult.rejectValue("id", "member.id.Overlap");
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
