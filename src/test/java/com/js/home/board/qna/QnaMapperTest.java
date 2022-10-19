package com.js.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.js.home.util.Pager;

@SpringBootTest
class QnaMapperTest {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@BeforeAll
	void befoClass() throws Exception{
		log.info("전체 Test 실행 전!");
	}
	
	@Autowired
	private QnaMapper qnaMapper;
	
	//@Test
	public void getListTest(Pager pager) throws Exception{
		List<QnaVO> ar = qnaMapper.getQnaList(pager);
		
		log.info("List : {}" , ar);
		
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void setQnaAddTest() throws Exception{
		QnaVO qnaVO = new QnaVO();
		qnaVO.setNum(null);
		qnaVO.setWriter("js");
		qnaVO.setTitle("하이");
		qnaVO.setContents("내용");
		
		int result = qnaMapper.setQnaAdd(qnaVO);
		
		log.info("result : " , result);
	}
	
	//@Test
	public void setQnaIndexTest() throws Exception{
		
		QnaVO qnaVO = new QnaVO();
		
		for(int i=0;i<200;i++) {
			
			qnaVO.setNum(null);
			qnaVO.setWriter("js" + i);
			qnaVO.setTitle("제목" + i);
			qnaVO.setContents("내용" + i);
			
			int result = qnaMapper.setQnaAdd(qnaVO);
			
			
		}
	}

}
