package com.hero.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class AuthenticationResponse {

	private String access_token;
	private String instance_url;
	private String token_type;
	private String issued_at;

}
