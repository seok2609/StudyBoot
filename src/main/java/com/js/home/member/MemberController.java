package com.js.home.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@GetMapping(value = "login")
	public String getMemberLogin() throws Exception{
		
		return "member/login";
	}
	
	@PostMapping(value = "login")
	public ModelAndView getMemberLogin(MemberVO memberVO, HttpServletRequest request, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		log.info("MemberController : 로그인 실행!");
		
		memberVO = memberService.getMemberLogin(memberVO);
		session = request.getSession();
		session.setAttribute("member", memberVO);
		
		mv.addObject("member", memberVO);
		
		mv.setViewName("redirect:../");
		
		return mv;
		
	}
	
	@GetMapping(value = "logout")
	public String getLotOut(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
	
	
	@GetMapping(value = "add")
	public String setMemberJoin() throws Exception{
		
		log.info("=========== MemberController에서 회원가입 GET실행 ==========");
		
		return "member/add";
	}
	
	
	@PostMapping(value = "add")
	public String setMemberJoin(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		log.info("=========== MemberController에서 회원가입 POST실행 ==========");
		
		int result = memberService.setMemberJoin(memberVO);
		
		if(result==1) {
			log.info("MemberController : 회원가입 성공! " );
		}else {
			log.info("MemberController : 회원가입 실패!");
		}
		
		
			
		return "redirect:./login";
	}
	
	@GetMapping(value = "idCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO) throws Exception{
		
		
		
		int result = memberService.getIdCheck(memberVO);
	
		
		return result;
	}
	
	@PostMapping(value = "test")
	@ResponseBody
	public MemberVO setTest(MemberVO memberVO) throws Exception{
		
		log.info("========================================");
		log.info("ID : {} ", memberVO.getId());
		log.info("Name : {}" , memberVO.getName());
		
		return memberVO;
	}
	
	
	
}
