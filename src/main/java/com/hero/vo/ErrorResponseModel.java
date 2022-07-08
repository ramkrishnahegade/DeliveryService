package com.hero.vo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ErrorResponseModel {

	@JsonProperty("errorcode")
	private String errorcode;
	@JsonProperty("errormessage")
	private String errormessage;
}
