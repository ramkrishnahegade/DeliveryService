package com.hero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.context.properties.ConfigurationPropertiesReportEndpoint.ApplicationConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hero.client.DeliveryOrderSalesforceClient;
import com.hero.client.SalesforceAPILogin;
import com.hero.client.vo.OrderStatusVO;
import com.hero.config.ApplicationPropertiesConfig;
import com.hero.vo.AuthenticationResponse;

@RestController
public class OrderStatusController {
	
	@Autowired
	private DeliveryOrderSalesforceClient orderSalesforceClient;
	
	@Autowired
	private SalesforceAPILogin apiLogin;
	
	@Autowired
	private ApplicationPropertiesConfig propertiesConfig;

	@RequestMapping
	public void orderStatusWebhook(@RequestBody @Validated OrderStatusVO orderStatusVO) {
		
		AuthenticationResponse authenticationResponse=apiLogin.login(propertiesConfig.getSalesforceUserName());
		orderSalesforceClient.postDeliveryOrderStatus(orderStatusVO,authenticationResponse.getAccess_token());
		
	}
}
