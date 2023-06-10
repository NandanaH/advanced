package snippet;

public class Snippet {
	spring:
	 application:
	   name: helloserver
	server:
	     port: 0
	eureka:
	  client:
	    register-with-eureka: true
	    fetch-registry: true
	    service-url:
	         defaultZone: http://localhost:8761/eureka
	  instance: 
	    hostname: localhost    	
	
}

