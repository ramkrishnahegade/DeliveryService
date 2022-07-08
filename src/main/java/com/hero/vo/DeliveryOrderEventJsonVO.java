package com.hero.vo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class DeliveryOrderEventJsonVO {

	@JsonProperty("schema")
	private String schema;
	
	@JsonProperty("payload")
	private DeliveryOrderEvent deliveryOrderEvents;
	
	@JsonProperty("event")
	private DeliveryOrderReplayVO deliveryOrderReplayVO;
	
}
