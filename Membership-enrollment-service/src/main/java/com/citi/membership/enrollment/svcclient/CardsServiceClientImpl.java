/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply.  
 * 
 * 
 */
package com.citi.membership.enrollment.svcclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.citi.membership.enrollment.model.CardDetailsRequest;
import com.citi.membership.enrollment.model.CardDetailsResponse;

/**
 * @author    ::asus
 * @Date      ::May 3, 2021
 * Description::
 */
public class CardsServiceClientImpl implements CardsServiceClient {

	public List<String> getCards(String cardNum) {
		// TODO ::Write rest client code to connect CardDetailsService and get the details
		return null;
	}

	public CardDetailsResponse getCardDetails(String cardNum) {
		// TODO ::Write rest client code to connect CardDetailsService and get the details
		String serviceUrl="";

		Map<String,String> vars=new HashMap<>();
		vars.put("hotel","42");
		vars.put("room","21");

		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept","application/json");
		headers.set("clientId", "mrp");
		headers.set("requstId",UUID.randomUUID().toString().substring(0,16));
		headers.set("msgTs","24-05-2021");

		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<CardDetailsResponse> cardDetailsResponse=restTemplate.getForEntity(serviceUrl,CardDetailsResponse.class,vars);
		return cardDetailsResponse.getBody();
	}

	public CardDetailsResponse getAllCardDetails(CardDetailsRequest cardDetailsRequest) {
		// TODO ::Write rest client code to connect CardDetailsService and get the details
		return null;
	}

}
