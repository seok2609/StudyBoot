package com.js.home.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails{

	@NotBlank(message="ID는 필수입니다.")
	private String id;
//	private String idCheck;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//<? super T>
		// ?는 any 를 뜻함, extends GrantedAuthority 를 상속받는 아무타입이면 된다.
	    // (+) <? super T> T나 T의 부모타입을 허용하겠다 라는 뜻
		List<GrantedAuthority> autoAuthorities = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			autoAuthorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));	// roleVo를 GrantedAuthority 타입에 담아줌
		}
		
		return autoAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getPw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정 만료 여부
		// true : 만료 안됨
		// false : 만료 됨, 로그인 불가
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠김 여부
		// true : 계정이 잠기지 않음
		// false : 계정이 잠김, 로그인 불가
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 만료 여부
		// true : 만료 안됨
		// false : 만료됨, 로그인 안됨
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정 사용 여부
		// true : 계정 활성화 (계정 사용 가능)
		// false : 계정 비활성화 (계쩡 사용 불가, 로그인 불가)
		
		return false;
	}
}
