package com.hero.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LeadEntity {

	private String id;
	

	private String company;
	
	private String lastName;

	@Override
    public String toString() {
    	return " ID :"+id+" Company :"+company+ "  lastName :"+lastName;
    }
	
}
