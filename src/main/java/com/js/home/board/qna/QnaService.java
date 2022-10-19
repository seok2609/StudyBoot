package com.js.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.js.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service

//Logger ~~~ 를 안해도 log객체를 사용할 수 있게 만들어 주는 어노테이션
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaVO> getQnaList(Pager pager) throws Exception{
		pager.makeStartRow();
		return qnaMapper.getQnaList(pager);
	}
	
//	public QnaVO getQnaDetail(QnaVO qnaVO) throws Exception{
//		return qnaMapper.getQnaDetail(qnaVO);
//	}
	
	public int setQnaAdd(QnaVO qnaVO) throws Exception{
		
		for(MultipartFile mf : qnaVO.getFiles()) {
			if(!mf.isEmpty()) {
				log.info("FileName : {} ", mf.getOriginalFilename());
			}
		}
		
		return 1; //qnaMapper.setQnaAdd(qnaVO);
	}
}
