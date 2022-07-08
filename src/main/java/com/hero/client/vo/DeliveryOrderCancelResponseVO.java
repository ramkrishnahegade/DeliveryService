package com.hero.client.vo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author RAMKRISHNAH
 * Created for Handling Order Cancel response from Delivery Partner 
 */
@Component
@Getter
@Setter
public class DeliveryOrderCancelResponseVO {

	@JsonProperty("status")
	private String status;

	@JsonProperty("message")
	private String message;
}
