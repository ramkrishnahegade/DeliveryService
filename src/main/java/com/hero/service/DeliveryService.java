package com.hero.service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hero.client.DeliveryOrderSalesforceClient;
import com.hero.client.DeliveryPartnerClient;
import com.hero.client.SalesforceAPILogin;
import com.hero.client.vo.DeliveryOrderResponseVO;
import com.hero.config.ApplicationPropertiesConfig;
import com.hero.vo.AuthenticationResponse;
import com.hero.vo.DeliveryOrderEvent;
import com.salesforce.emp.connector.EmpConnector;
import com.salesforce.emp.connector.TopicSubscription;
import com.salesforce.emp.connector.example.SalesforceEventClientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeliveryService {

	/*
	 * @Autowired private LeadRepository leadRepository;
	 */
	
	@Autowired
	private ApplicationPropertiesConfig appConfig;
	
	@Autowired
	private SalesforceAPILogin salesforceAPILogin;
	
	@Autowired
	private DeliveryPartnerClient deliveryPartnerClient;
	
	@Autowired
	private DeliveryOrderSalesforceClient deliveryOrderSalesforceClient;
	
	private static final ExecutorService workerThreadPool = Executors.newFixedThreadPool(10);
	
	/*
	 * public void getLead() {
	 * 
	 * log.info(" saved : "+leadRepository.save());
	 * log.info((leadRepository.getLeads()).toString());
	 * log.info(" updated : "+leadRepository.update());
	 * log.info((leadRepository.getLeads()).toString()); //log.info(" deleted : "+
	 * leadRepository.deleteById()); }
	 */
	
	public void subscribeDeliveryOrderEvent(EmpConnector  connector) {
		ObjectMapper objectMapper = new ObjectMapper();
		AuthenticationResponse authenticationResponse= salesforceAPILogin.login(appConfig.getSalesforceUserName());
		log.info("========="+authenticationResponse.getAccess_token());
		Consumer<Map<String, Object>> consumer = event ->{ 

			CompletableFuture.runAsync(()->{
				DeliveryOrderEvent deliveryOrderEvent = null;
				log.info("event.get(\"payload\").toString()"+event);
				deliveryOrderEvent = objectMapper.convertValue(event.get("payload"), DeliveryOrderEvent.class);
				DeliveryOrderResponseVO  deliveryOrderResponseVO = deliveryPartnerClient.postDeliveryOrder(deliveryOrderEvent);
				deliveryOrderSalesforceClient.postDeliveryObjectAck(deliveryOrderResponseVO, authenticationResponse.getAccess_token(), deliveryOrderEvent.getId());
			}, workerThreadPool);
		};
		
		CompletableFuture<TopicSubscription> deliveryOrderSubscription=SalesforceEventClientService.getTopicSubscription(connector, appConfig.getDeliveryOrderEvent(), consumer,null);
		
		
		//	if(null!= deliveryOrderSubscription.toString() && StringUtil.isNotBlank(null));
		
	}
	
	
}
