package com.hero.vo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@JsonInclude(value = Include.NON_EMPTY)
public class DeliveryOrderEvent {

	@JsonProperty("DeliveryAddress__c")
	private String deliveryAddress;
	
	@JsonProperty("DeliveryBookingDate__c")
	private String deliveryBookingDate;
	
	@JsonProperty("DeliveryPincode__c")
	private String deliveryPincode;
	

	@JsonProperty("Pickup_Branch_Address__c")
	private String pickupBranchAddress;
	

	@JsonProperty("Sale_Delivery_Number__c")
	private String saleDeliveryNumber;
	
	@JsonProperty("Pickup_Postal_Code__c")
	private String pickupPostalCode;
	
	@JsonProperty("DeliveryOrder_Id__c")
	private String id;
	
	@JsonProperty("CreatedById")
	private String createdById;
	
	@JsonProperty("CreatedDate")
	private String CreatedDate;	

}
