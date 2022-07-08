package com.hero.client.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryItemDetailVO {

	@JsonProperty("item_name")
	private String itemName;
	
	@JsonProperty("item_quantity")
	private String itemQuantity;
	
	@JsonProperty("item_price_per_each")
	private String itemPricePerEach;
	
	@JsonProperty("total_item_price")
	private String totalItemPrice;
	
   

}
