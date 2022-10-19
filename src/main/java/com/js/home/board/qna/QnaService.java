package com.js.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.home.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaVO> getQnaList(Pager pager) throws Exception{
		pager.makeStartRow();
		return qnaMapper.getQnaList(pager);
	}
}
