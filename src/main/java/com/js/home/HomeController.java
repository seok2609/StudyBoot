package com.js.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.js.home.board.qna.QnaMapper;
import com.js.home.board.qna.QnaVO;
import com.js.home.util.Pager;

@Controller
public class HomeController {

	//@Value("${my.message.hi}")
	private String message;
	@Value("${my.default}")
	private String app;
	
//	private final Logger log = LoggerFactory.getLogger(HomeController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaMapper qnaMapper;

	
	@GetMapping("/")
	public String home() throws Exception{
		log.info("====================================");
		
		log.info("message : {} ", message);
		log.info("default : {} ", app);
		
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
