package com.oracle.actuator_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstApp {

	@RequestMapping("/myFirstPage")
	public String myWebApp() {
		return "First microservices";
	}

	@RequestMapping("/secondPage")
	public String sayHello(@RequestParam String name) {
		return "Hello: " + name;
	}
	
	@RequestMapping(path="/varforpathExample/{name}")
	public String sayHello2(@PathVariable String name) {
		return "Hello: " + name;
	}
	
	@GetMapping("/secondSampleBean")
	public SecondSampleBean secondBean() {
		return new SecondSampleBean("Lalit");
	}
}
