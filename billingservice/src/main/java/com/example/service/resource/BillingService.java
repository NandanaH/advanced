package com.example.service.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/billingservice")
public class BillingService {
	@Value("name")
	String strMessage;
 
	
@GetMapping
public String status() {
	return "bill generated";
}
	

}

