package com.js.home;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.js.home.board.qna.QnaMapper;
import com.js.home.board.qna.QnaVO;
import com.js.home.member.MemberVO;
import com.js.home.util.Pager;

@Controller
public class HomeController {

	//@Value("${my.message.hi}")
	private String message;
	@Value("${my.default}")
	private String app;
	
//	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	

	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin Role";
	}
	
	
	@GetMapping("/manager")
	@ResponseBody
	public String manager() {
		return "Manager Role";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String member() {
		return "Member Role";
	}

	
	@GetMapping("/")
	public String home(HttpSession session) throws Exception{
		log.info("====================================");
		
		//세션에 저장되있는 키값을 가져온다(get)
		//Spring Security에 있는 세션
		Enumeration<String> en = session.getAttributeNames();
		
		//반복문
		while(en.hasMoreElements()) { //Elements가 더 있냐 
			
			String key = en.nextElement();
			log.info("Key ====> {} ", key);
			
		}
		
		SecurityContextImpl context = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
		if(context != null) {
			
//			log.info("Context ::::::: {} ", ((MemberVO)context.getAuthentication().getPrincipal()).getId());
			log.info("Context =======>>>>>>>> {} ", context);
		}
		
		log.info("message : {} ", message);
		log.info("default : {} ", app);
		
		log.info("====================================");
		
//		log.error("Error Message");
//		log.warn("Warn Message");
//		log.info("Info Message");
//		log.debug("Debug Message");
//		log.trace("Trace Message");
		
		Pager pager = new Pager();
//		List<QnaVO> ar = qnaMapper.getQnaList(pager);
//		
//		
//		log.info("List : {}  size {}", ar, ar.size());
	
		
		return "/index";
	}
}
