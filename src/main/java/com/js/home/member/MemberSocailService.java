package com.js.home.member;

import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberSocailService extends DefaultOAuth2UserService{
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
	
		log.info("==========소셜 로그인 시도========");
		log.info("UserRequest {} ", userRequest);
		log.info("AccessTocken : {} ", userRequest.getAccessToken());
		log.info("ClientRegistration : {} ", userRequest.getClientRegistration());
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
		log.info("========================사용자 정보=======================");
		log.info("Name : {} ", oAuth2User.getName());
		log.info("Attributes : {} ", oAuth2User.getAuthorities());
		log.info("auth {} ", oAuth2User.getAuthorities());
		
		return null;
	}

	
	
	

}
