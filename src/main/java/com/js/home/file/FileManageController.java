package com.js.home.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.js.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {
	
	
	@GetMapping(value = "/fileDown/{path}") //RestFul, RestAPI
	public ModelAndView fileDown(@PathVariable String path, QnaFileVO qnaFileVO) throws Exception{
		//@PathVariable = 매개변수에 있는 path를 사용할때 GetMapping에 있는 path를 변수로 활용한다는 어노테이션
		log.info("Path : {} ", path);
		
		ModelAndView mv = new ModelAndView();
		
		
		
		//DB에서 정보조회
		qnaFileVO.setFileName("6fd44e23-2976-49f9-b09c-0075362c35a5_.jpg");
		qnaFileVO.setOriName("jonf.jpg");
		
		mv.addObject("fileVO" , qnaFileVO);
		mv.addObject("path", path);
		
		mv.setViewName("fileManager");
		
		return mv;
	}

//	@GetMapping(value = "/fileDown/notice")
//	public ModelAndView fileDownNotice(QnaFileVO qnaFileVO) throws Exception{
//		
//		ModelAndView mv = new ModelAndView();
//		
//		
//		
//		//DB에서 정보조회
//		qnaFileVO.setFileName("1111.jpg");
//		qnaFileVO.setOriName("1111.jpg");
//		
//		mv.addObject("fileVO" , qnaFileVO);
//		mv.addObject("path", "notice");
//		
//		mv.setViewName("fileManager");
//		
//		return mv;
//	}
}
