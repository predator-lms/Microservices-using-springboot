package com.oracle.feign_client_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class UserController {
		
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/user/servicecall")
	public Flux<String> getUser(){
		return userService.getUserById();
	}
}
