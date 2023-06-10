package com.example.advanced.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/service")
public class HelloService {
	
	@Autowired
	Environment environment; //it is a reference to property file
	@Value("name")
	String strMessage;
 
	
@GetMapping
public String wlecome() {
	String port=environment.getProperty("server.port");
	return "Programming Microservice@"+port;
}
	

}
