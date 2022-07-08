package com.hero.client.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class DeliveryOrderMessageVO {

	@JsonProperty("awbnumber")
	private String awb_number;
	
	@JsonProperty("item_details")
	private List<DeliveryItemDetailVO> deliveryItemDetails;
}
