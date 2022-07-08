package com.hero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hero.service.DeliveryService;

@RestController
public class LeadController {

	@Autowired
	private DeliveryService deliveryService;
	
	@GetMapping("/lead")
	public void getLead() {
		
		deliveryService.getLead();
	}
}
