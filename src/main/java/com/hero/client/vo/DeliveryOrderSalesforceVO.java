package com.hero.client.vo;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class DeliveryOrderSalesforceVO {

	@JsonProperty("dmpl_awbNumber__c")
	private String awbNumber;
	
	@JsonProperty("Id")
	private String id;
	
	@JsonProperty("status")
	private String status;

	
}
