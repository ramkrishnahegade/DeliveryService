package com.hero.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hero.client.vo.DeliveryOrderResponseVO;
import com.hero.client.vo.DeliveryOrderSalesforceVO;
import com.hero.client.vo.OrderStatusVO;
import com.hero.config.ApplicationPropertiesConfig;
import com.hero.util.Constants;

@Service
public class DeliveryOrderSalesforceClient {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ApplicationPropertiesConfig propertiesConfig;
	
	public void postDeliveryObjectAck(DeliveryOrderResponseVO deliveryOrderResponseVO,String accessToken, String deliveryOrderId) {
		
		DeliveryOrderSalesforceVO orderSalesforceVO=new DeliveryOrderSalesforceVO();
		//orderSalesforceVO.setAwbNumber(deliveryOrderResponseVO.getDeliveryOrderMessageVO().getAwb_number());
		orderSalesforceVO.setAwbNumber("4454");
		HttpEntity<DeliveryOrderSalesforceVO> httpEntity=new HttpEntity<DeliveryOrderSalesforceVO>(orderSalesforceVO);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(Constants.AUTHORIZATION, Constants.BEARER + accessToken);

		ResponseEntity<DeliveryOrderResponseVO> responseEntityOrderResponse = restTemplate.exchange(
				propertiesConfig.getDeliveryPartnerCreateOrderUrl()+"/"+deliveryOrderId, HttpMethod.PATCH, httpEntity,
				DeliveryOrderResponseVO.class);
	}
	
	public void postDeliveryOrderStatus(OrderStatusVO orderStatusVO,String accessToken) {
		DeliveryOrderSalesforceVO orderSalesforceVO=new DeliveryOrderSalesforceVO();
		orderSalesforceVO.setAwbNumber(orderStatusVO.getAwbNum());
		orderSalesforceVO.setStatus(orderStatusVO.getOrderStatus());
		HttpEntity<DeliveryOrderSalesforceVO> httpEntity=new HttpEntity<DeliveryOrderSalesforceVO>(orderSalesforceVO);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(Constants.AUTHORIZATION, Constants.BEARER + accessToken);

		ResponseEntity<DeliveryOrderResponseVO> responseEntityOrderResponse = restTemplate.exchange(
				propertiesConfig.getDeliveryPartnerCreateOrderUrl()+Constants.SLASH+orderStatusVO.getAwbNum(), HttpMethod.PATCH, httpEntity,
				DeliveryOrderResponseVO.class);
	}
}
