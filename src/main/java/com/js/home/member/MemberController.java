package com.js.home.member;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//	public String getMemberLogin(@RequestParam(required=false) boolean error, String message) throws Exception{
	public String getMemberLogin(@RequestParam(defaultValue = "false", required=false) boolean error, String message, Model model) throws Exception{
		
		if(error) {
			model.addAttribute("msg", "ID또는 PW를 확인하세요");
		}
		
		//Controller에서 받아서 jsp로 다시 받아도됨
		
		return "member/login";
	}
	
	@PostMapping(value = "login")
	public ModelAndView getMemberLogin() throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		log.info("MemberController : 로그인 실행!");
		
		
		mv.setViewName("member/login");
		
		return mv;
		
	}
	
	@GetMapping(value = "logout")
	public String getLogOut(HttpSession session) throws Exception{
		log.info("============내가 만든 쿠키~~~================");
		session.invalidate();
		
		return "redirect:../";
	}
	
	
	@GetMapping(value = "add")
	public String setMemberJoinGet(@ModelAttribute MemberVO memberVO) throws Exception{
//		MemberVO memberVO = new MemberVO();
//		model.addAttribute(memberVO);
		
		log.info("=========== MemberController에서 회원가입 GET실행 ==========");
		
		return "member/add";
	}
	
	
	@PostMapping(value = "add")
	public ModelAndView setMemberJoinPost(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv) throws Exception{
		
		log.info("=========== MemberController에서 회원가입 POST실행 ==========");
		
//		if(bindingResult.hasErrors()) {		//이 코드는 Annotation만 검증하는 코드 - @Valid
//			//검증에 실패하면 회원가입하는 jsp로 이동 foward
//			log.info("==========검증 에러 발생==========");
//			mv.setViewName("member/add");
//			return mv;
//		}
		
		boolean check = memberService.getMemberError(memberVO, bindingResult);
		if(check) {
			log.info("==========검증 에러 발생==========");
			mv.setViewName("member/add");
			//===================================================
			List<FieldError> fr = bindingResult.getFieldErrors();			//어디서 에러가 발생했는지 알 수 있는 코드
			
			for(FieldError fieldError:fr) {
				log.info("FieldError => {} ", fieldError);
				log.info("Field => {} ",fieldError.getField());
				log.info("Message => {} ", fieldError.getRejectedValue());
				log.info("Default => {} " , fieldError.getDefaultMessage());
				log.info("Code => {} ", fieldError.getCode());
				mv.addObject(fieldError.getField(), fieldError.getDefaultMessage());
				log.info("==================================================================");
				
			}
			
			return mv;
		}
		
		//int result = memberService.setMemberJoin(memberVO);
		
		
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping(value = "idCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO) throws Exception{
		
		
		
		int result = memberService.getIdCheck(memberVO);
		
//		if(result == 0) {
//			throw new Exception("테스트");
//		}
	
		
		return result;
	}
	
	@PostMapping(value = "test")
	@ResponseBody
	public MemberVO setTest(MemberVO memberVO, String [] ar) throws Exception{
		
		log.info("========================================");
		log.info("ID : {} ", memberVO.getId());
		log.info("Name : {}" , memberVO.getName());
		
		for(String s : ar) {
			log.info("ar : {} ", s);
		}
		
		return memberVO;
	}
	
	@GetMapping(value = "myPage")
	public String getMyPage() throws Exception{
		
		return "member/myPage";
	}

	
	
	
}
