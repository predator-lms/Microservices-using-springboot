package com.oracle.property_access_service.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="property-file")
public class PropertyAccessBean {
	private String name;
	private String description;
	
	public PropertyAccessBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
