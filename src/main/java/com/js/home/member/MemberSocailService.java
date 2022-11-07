package com.js.home.member;

import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberSocailService extends DefaultOAuth2UserService{@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
	
		log.info("==========소셜 로그인 시도========");
		log.info("UserRequest {} ", userRequest);
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
