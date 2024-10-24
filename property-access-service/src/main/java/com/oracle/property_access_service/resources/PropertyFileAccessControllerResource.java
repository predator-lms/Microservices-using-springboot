package com.oracle.property_access_service.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.oracle.property_access_service.beans.PropertyAccessBean;
import com.oracle.property_access_service.beans.PropertyAccessValue;

@RestController
@RequestMapping("/access")
public class PropertyFileAccessControllerResource {
	
	@Autowired
	PropertyAccessBean propertyAccessBean;
	
	@GetMapping("accessPropertyFile")
	public PropertyAccessValue accessPropertyFile() {
		refreshActuaor();
		return new PropertyAccessValue(propertyAccessBean.getName(), propertyAccessBean.getDescription());
	}
	
	public void refreshActuaor() {
		RestTemplate template = new RestTemplate();
		final String base_url = "http://localhost:8100/actuator/refresh";
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<String> results = template.postForEntity(base_url, entity, String.class);
	}
}
