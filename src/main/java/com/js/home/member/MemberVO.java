package com.js.home.member;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {

	@NotBlank(message="ID는 필수입니다.")
	private String id;
	@NotBlank
//	@Size(max=10, min=8)
	private String pw;
	private String pwCheck;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	
	@Range(max=150, min=0)
	private int age;
	
	@Past(message="과거 날짜 이여야 합니다")
	private Date birth;
	private boolean enAbled;
	
	private List<RoleVO> roleVOs;
}
