package com.js.home.board.qna;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
//@Getter
//@Setter
public class QnaVO extends QnaFileVO{
	
	private Long num;
	private String writer;
	private String title;
	private String contents;
	private Long hits;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
	
	private MultipartFile [] files;
	
	private List<QnaFileVO> qnaFileVOs;

}
