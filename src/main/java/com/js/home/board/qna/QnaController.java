package com.js.home.board.qna;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.js.home.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	
	@Autowired
	private QnaService qnaService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "list")
	public ModelAndView getQnaList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		List<QnaVO> ar = qnaService.getQnaList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
		
	}
	
//	@GetMapping(value = "detail")
//	public ModelAndView getQnaDetail(QnaVO qnaVO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		qnaService.getQnaDetail(qnaVO);
//		
//		mv.addObject("dto", qnaVO);
//		mv.setViewName("board/detail");
//		
//		return mv;
//	}
	
	
	@GetMapping(value = "add")
	public String setQnaAdd() throws Exception{
		
		return "board/write";
	}
	
	@PostMapping(value = "add")
	public ModelAndView setQnaAdd(QnaVO qnaVO, RedirectAttributes redirectAttributes) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.setQnaAdd(qnaVO);
		
		redirectAttributes.addAttribute("result", result);
//		mv.addObject("result", result);
		mv.setViewName("redirect:./list");
		
		if(result == 1) {
			log.info("Result : {}", result);
		}else {
			log.info("실패");
		}
		
		return mv;
	}
}
