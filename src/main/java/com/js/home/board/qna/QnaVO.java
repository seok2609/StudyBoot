package com.js.home.board.qna;

import java.sql.Date;

import lombok.Data;

@Data
public class QnaVO {
	
	private Long num;
	private String writer;
	private String title;
	private String contents;
	private Long hits;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;

}
