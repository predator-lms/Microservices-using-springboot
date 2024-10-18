package com.oracle.feign_client_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.feign_client_service.util.FeignServiceUtil;

@RestController
@RequestMapping("/feigndemo")
public class FeignController {

	public FeignController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	FeignServiceUtil util;
	
	@GetMapping("/customer-serviceName")
	public String getServiceName() {
		return util.getServiceName();
	}
	
	@GetMapping("/customer-serviceAddress")
	public String getServiceAddress() {
		return util.getServiceAddress();
	}
	
	 @GetMapping("/customer-serviceDetails")
	 public String getServiceDetails() {
		 return util.getServiceDetails();
	 }

}
