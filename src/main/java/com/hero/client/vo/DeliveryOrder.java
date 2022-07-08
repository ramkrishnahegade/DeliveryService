package com.hero.client.vo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class DeliveryOrder {

	@JsonProperty("customer_name")
	private String customerName;
	
	@JsonProperty("reference_number")
	private String orderId;
	
	@JsonProperty("customer_mobile")
	private String mobileNumber;
	
	@JsonProperty("item_name")
	private String itemName;
	
	@JsonProperty("delivery_address")
	private String deliveryAddress;
	
	@JsonProperty("delivery_postal_code")
	private String deliveryPostalCode;
	
	@JsonProperty("pickup_postal_code")
	private String picukupPostalCode;
	
	@JsonProperty("pickup_address")
	private String pickupHubAddress;
	
	@JsonProperty("pickup_hub")
	private String pickuphub;
	
	@JsonProperty("expected_delivery_time")
	private String expectedDeliveryTime;
	
	
	
}
