package com.hero.client.vo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class OrderStatusVO {

	@JsonProperty("WaybillNo")
	private String awbNum;
	
	@JsonProperty("OrderStatus")
	private String OrderStatus;
	
	@JsonProperty("StatusDateTime")
	private String StatusDateTime;
	
}
