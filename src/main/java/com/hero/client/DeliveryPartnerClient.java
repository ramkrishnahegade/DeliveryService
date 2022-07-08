package com.hero.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hero.client.vo.DeliveryOrder;
import com.hero.client.vo.DeliveryOrderCancelResponseVO;
import com.hero.client.vo.DeliveryOrderResponseVO;
import com.hero.config.ApplicationPropertiesConfig;
import com.hero.util.Constants;
import com.hero.vo.DeliveryOrderEvent;
/**
 * 
 * @author RAMKRISHNAH
 *
 */
@Service
public class DeliveryPartnerClient {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DeliveryOrder deliveryOrder;
	
	@Autowired
	private ApplicationPropertiesConfig propertiesConfig;
	
	
	
	public DeliveryOrderResponseVO postDeliveryOrder(DeliveryOrderEvent deliveryOrderEvent) {
		deliveryOrder = mapDeliveryOrderEvent(deliveryOrderEvent);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add(Constants.API_KEY, propertiesConfig.getDeliveryApiKey());
		HttpEntity<DeliveryOrder> httpEntity = new HttpEntity<DeliveryOrder>(deliveryOrder, headers);
		try {
		ResponseEntity<DeliveryOrderResponseVO> responseEntityOrderResponse = restTemplate.exchange(
				propertiesConfig.getDeliveryPartnerCreateOrderUrl(), HttpMethod.POST, httpEntity,
				DeliveryOrderResponseVO.class);
		if(null!= responseEntityOrderResponse && responseEntityOrderResponse.getStatusCode().is2xxSuccessful()
				&& propertiesConfig.getCreateOrderSuccessStatus().equalsIgnoreCase(responseEntityOrderResponse.getBody().getStatus())) {
			return responseEntityOrderResponse.getBody();
		}else {
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	private DeliveryOrder mapDeliveryOrderEvent(DeliveryOrderEvent deliveryOrderEvent) {
		deliveryOrder.setCustomerName(Constants.CUSTOMER_NAME);
		deliveryOrder.setMobileNumber(Constants.MOBILE_NUMBER);
		deliveryOrder.setDeliveryAddress(deliveryOrderEvent.getDeliveryAddress());
		deliveryOrder.setExpectedDeliveryTime(deliveryOrderEvent.getDeliveryBookingDate());
		deliveryOrder.setDeliveryPostalCode(deliveryOrderEvent.getDeliveryPincode());
		deliveryOrder.setOrderId(deliveryOrderEvent.getSaleDeliveryNumber());
		deliveryOrder.setPickuphub(deliveryOrderEvent.getPickupBranchAddress());
		deliveryOrder.setPicukupPostalCode(deliveryOrderEvent.getPickupPostalCode());
		return deliveryOrder;
	}
	
	public void postDeliveryOrderCance(DeliveryOrderEvent deliveryOrderEvent) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.API_KEY, propertiesConfig.getDeliveryApiKey());
		HttpEntity entity=new HttpEntity<>(headers);
		ResponseEntity<DeliveryOrderCancelResponseVO> responseEntity=restTemplate.exchange(propertiesConfig.getSalesforceDeliveryOrcerCancelUrl(), HttpMethod.PUT,entity , DeliveryOrderCancelResponseVO.class);
	}
	
	
}
