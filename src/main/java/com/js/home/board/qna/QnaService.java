package com.js.home.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.js.home.util.FileManager;
import com.js.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service

//Logger ~~~ 를 안해도 log객체를 사용할 수 있게 만들어 주는 어노테이션
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	@Value("${app.upload.qna}")
	private String path;
	@Autowired
	private FileManager fileManager;
	
	public List<QnaVO> getQnaList(Pager pager) throws Exception{
		pager.makeStartRow();
		return qnaMapper.getQnaList(pager);
	}
	
	public QnaVO getQnaDetail(QnaVO qnaVO) throws Exception{
		return qnaMapper.getQnaDetail(qnaVO);
	}
	
	
	@Transactional(rollbackFor = Exception.class)	//이 setQnaAdd를 실행하다가 Exception이 발생하면 rollback을 시키는 어노테이션
	public int setQnaAdd(QnaVO qnaVO) throws Exception{
		int result = qnaMapper.setQnaAdd(qnaVO);
		
		log.info("path : {}", path);
		File file = new File(path);
		
		if(!file.exists()) {
			boolean check = file.mkdirs();
			log.info("Check : {}", check);
		}
		
		
		for(MultipartFile mf : qnaVO.getFiles()) {
			
			
			if(!mf.isEmpty()) {
				log.info("FileName : {} ", mf.getOriginalFilename());
				String fileName = fileManager.saveFile(mf, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setFileName(fileName);
				qnaFileVO.setOriName(mf.getOriginalFilename());
				qnaFileVO.setNum(qnaVO.getNum());
				qnaMapper.setQnaFileAdd(qnaFileVO);
			}
		}
		
		return result; //qnaMapper.setQnaAdd(qnaVO);
	}
	
	
	public QnaFileVO getQnaFileDetail(QnaFileVO qnaFileVO) throws Exception{
		
		return qnaMapper.getQnaFileDetail(qnaFileVO);
	}
	
	public int setQnaFileDelete(QnaFileVO qnaFileVO) throws Exception{
		
		return qnaMapper.setQnaFileDelete(qnaFileVO);
	}
}
