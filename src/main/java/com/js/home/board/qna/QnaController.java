package com.js.home.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
//	@ModelAttribute("board")
//	public String getBoard() {
//		return "qna";
//	}
	
	@GetMapping(value = "list")
	public ModelAndView getQnaList(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		List<QnaVO> ar = qnaService.getQnaList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
		
	}
	
	@GetMapping(value = "detail")
	public ModelAndView getQnaDetail(QnaVO qnaVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		qnaVO = qnaService.getQnaDetail(qnaVO);
		
//		mv.addObject("dto", qnaVO);
		mv.addObject("qnaVO", qnaVO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	
	@GetMapping(value = "add")
	public String setQnaAdd(@ModelAttribute QnaVO qnaVO) throws Exception{
		
		return "board/write";
	}
	
	@PostMapping(value = "add")
	public ModelAndView setQnaAdd(@Valid QnaVO qnaVO, BindingResult bindingResult ,RedirectAttributes redirectAttributes) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			log.info("==========에러발생==========");
			mv.setViewName("board/write");
			return mv;
		}
		
		int result = qnaService.setQnaAdd(qnaVO);
		
		redirectAttributes.addAttribute("result", result);
//		mv.addObject("result", result);
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
	@GetMapping(value = "update")
	public String setQnaUpdate(Model model, QnaVO qnaVO) throws Exception{
		
		qnaVO = qnaService.getQnaDetail(qnaVO);
		
		model.addAttribute("qnaVO", qnaVO);
		
		return "board/update";
	}
	
	@PostMapping(value = "update")
	public ModelAndView setQnaUpdate(QnaVO qnaVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:./detail?num="+qnaVO.getNum());
//		mv.setViewName("board/update");
		
//		qnaVO = qnaService.getQnaDetail(qnaVO);
		int result = qnaService.setQnaUpdate(qnaVO);
		
		mv.addObject("qnaVO", qnaVO);
		
		return mv;
	}
	
	@PostMapping(value ="fileDelete")
	@ResponseBody
	public int setQnaFileDelete(QnaFileVO qnaFileVO) throws Exception{
		
		int result = qnaService.setQnaFileDelete(qnaFileVO);
		
		return result;
	}
}
