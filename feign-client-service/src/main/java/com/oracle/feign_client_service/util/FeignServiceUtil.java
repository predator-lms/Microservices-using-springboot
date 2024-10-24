package com.oracle.feign_client_service.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="feignDemo", url="http://localhost:8081/user")
public interface FeignServiceUtil {

	@GetMapping("/serviceName")
	String getServiceName();
	
	@GetMapping("/serviceAddress")
	String getServiceAddress();

	@GetMapping("/serviceDetails")
	String getServiceDetails();
}
