package com.oracle.FirstExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdEndpoint {

	public ThirdEndpoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	ExampleProperties props;
	
	@RequestMapping("/greetothers")
	public String greet(@RequestParam String name) {
		return props.getGreeting() + ": " + name;
	}
	
}
