package com.js.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.js.home.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping(value = "list")
	public ModelAndView getQnaList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		List<QnaVO> ar = qnaService.getQnaList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
		
	}
}
