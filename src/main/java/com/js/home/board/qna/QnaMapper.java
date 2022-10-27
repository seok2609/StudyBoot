package com.js.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.js.home.util.Pager;

//@Repository
@Mapper
public interface QnaMapper {
	
	public List<QnaVO> getQnaList(Pager pager) throws Exception;
	
	public QnaVO getQnaDetail(QnaVO qnaVO) throws Exception;
	
	public int setQnaAdd(QnaVO qnaVO) throws Exception;
	
	public int setQnaFileAdd(QnaFileVO qnaFileVO) throws Exception;
	
	public QnaFileVO getQnaFileDetail(QnaFileVO qnaFileVO) throws Exception;
	
	public int setQnaFileDelete(QnaFileVO qnaFileVO) throws Exception;
}
