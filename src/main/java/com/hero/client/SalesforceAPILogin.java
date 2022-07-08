package com.hero.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.hero.config.ApplicationPropertiesConfig;
import com.hero.util.Constants;
import com.hero.vo.AuthenticationResponse;

@Component
public class SalesforceAPILogin {
	
	@Autowired
	private ApplicationPropertiesConfig propertiesConfig;
	
	@Autowired
	private RestTemplate restTemplate;

	@Cacheable(value="partTypeCache", key="#userName")
	public AuthenticationResponse login(String userName){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
		 
		params.add(Constants.USERNAME, propertiesConfig.getSalesforceUserName());
		params.add(Constants.PASSWORD, propertiesConfig.getSalesforcesecuritytoken() );
		params.add(Constants.CLIENT_SECRET, propertiesConfig.getConsumerSecrete() );
		params.add(Constants.CLIENT_ID, propertiesConfig.getConsumerkey());
		params.add(Constants.GRANT_TYPE,Constants.PASSWORD);
		 
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		 
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthenticationResponse> response = restTemplate.postForEntity(propertiesConfig.getSalesforceOAuthLoginUrl(), request, AuthenticationResponse.class);
		return response.getBody();
		}
}
