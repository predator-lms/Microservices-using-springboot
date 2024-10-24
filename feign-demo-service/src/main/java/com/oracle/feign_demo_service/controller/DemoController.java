package com.oracle.feign_demo_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DemoController {

	public DemoController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/serviceName")
	public String getServiceName() {
		return "Welcome Oracle - India";
	}
	
	@GetMapping("/serviceAddress")
	public String getServiceAddress() {
		return "Location : Oralce Noida";
	}
	
	 @GetMapping("/serviceDetails")
	 public String getServiceDetails() {
		 return "Microservices using springboot and spring cloud.";
	 }

}
