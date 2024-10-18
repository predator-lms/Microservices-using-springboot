package com.oracle.FirstExample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("oracleprops")
public class ExampleProperties {

	public ExampleProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String greeting = "Thank You";

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	
}
