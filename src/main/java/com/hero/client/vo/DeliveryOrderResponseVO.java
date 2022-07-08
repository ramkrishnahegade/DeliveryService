package com.hero.client.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryOrderResponseVO {

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("message")
	private DeliveryOrderMessageVO deliveryOrderMessageVO;
	
	
}
