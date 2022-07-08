package com.hero.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class ApplicationPropertiesConfig {

	private String salesforceUserName;
	private String salesforcesecuritytoken;
	
	private String testPlatformEvent;
	private String deliveryOrderEvent;
	

	private String deliveryPartnerCreateOrderUrl;
	private String deliveryPartnerApiKey;	
	private String deliveryApiKey;
	
	private String consumerSecrete;
	private String consumerkey;
	
	private String salesforceOAuthLoginUrl;
	
	private String createOrderSuccessStatus;
	
	private String salesforceDeliveryOrderUrl;
	
	private String salesforceDeliveryOrcerCancelUrl;
	
}
