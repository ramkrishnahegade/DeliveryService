package com.hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.hero.config.ApplicationPropertiesConfig;
import com.hero.service.DeliveryService;
import com.salesforce.emp.connector.EmpConnector;
import com.salesforce.emp.connector.TopicSubscription;
import com.salesforce.emp.connector.example.SalesforceEventClientService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DeliveryServiceApplication  implements CommandLineRunner{

	@Autowired
	private  ApplicationPropertiesConfig appConfig;
	
	@Autowired
	private DeliveryService deliveryService;
	
	public static void main(String[] args) {
		SpringApplication.run(DeliveryServiceApplication.class, args);
		
		}

	@Override
	public void run(String... args) throws Exception {
		EmpConnector connector=SalesforceEventClientService.getSalesforceEventBus(appConfig.getSalesforceUserName(), appConfig.getSalesforcesecuritytoken());
		deliveryService.subscribeDeliveryOrderEvent(connector);
		
	}
	
	   @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }


}
