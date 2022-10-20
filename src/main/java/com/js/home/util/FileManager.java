package com.js.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.js.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileManager extends AbstractView{
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		QnaFileVO qnaFileVO = (QnaFileVO)model.get("fileVO");
		String path = (String)model.get("path");
		
		log.info("=======================================");
		log.info("FILEVO {} ", qnaFileVO);
		
		File file = new File("C:/result/upload/" +path, qnaFileVO.getFileName());
		
		//한글 처리
		response.setCharacterEncoding("UTF-8");
		
		//총 파일의 크기
		response.setContentLengthLong(file.length());
		
		//다운로드시 파일의 이름을 인코딩
		String oriName = URLEncoder.encode(qnaFileVO.getOriName(), "UTF-8");
		
		
		//header 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+oriName+"\"");	//attachment : 첨부
		response.setHeader("Content-Transfer-Encoding", "binary");	//binary : text가 아니라 이진 파일이다.
		
		//HDD에서 파일을 읽고 
		FileInputStream fis = new FileInputStream(file);	//위에 생성해놓은 file객체를 읽어온다 (input = 읽기)
		
		//Client 로 전송 준비
		OutputStream os = response.getOutputStream();
		
		//전송
		FileCopyUtils.copy(fis, os);
		
		//전송 후 자원해제
		os.close();
		fis.close();
//		log.info("--------------------------");
//		log.info("File DownLoad View");
		
	}

	public String saveFile(MultipartFile mf, String path) throws Exception{
		

		
		//1. 중복되지 않는 파일명 생성 (UUID, Date)
		String fileName = UUID.randomUUID().toString();
		
		//2. 확장자
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		bf.append("_");
		
		//파일명과 확장자 분리
		String ex = mf.getOriginalFilename();	//이나은.jpg
		
		ex = ex.substring(ex.lastIndexOf("."));	//파일명은 항상 같지 않고 확장자는 거의 일정하므로 lastIndexOf를 써서 뒤에서부터 "."를 찾아서 잘라냄
		
		bf.append(ex);
		log.info("fileName : {} ", bf.toString());
		
		fileName = bf.toString();
		
		//3. File 저장
		File file = new File(path, bf.toString());
		
		//FileCopyUtils
		//MultipartFile
		
//		FileCopyUtils.copy(mf.getBytes(), file);
		mf.transferTo(file);
		
		
		return fileName;
//		return bf.toString();
	}
}
