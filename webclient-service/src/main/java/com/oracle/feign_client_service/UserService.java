package com.oracle.feign_client_service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class UserService {
	private final WebClient webClient;
	
	public UserService(WebClient webClient) {
		super();
		this.webClient = webClient;
	}
	
	public Flux<String> getUserById(){
		return webClient.get().uri("/user/serviceName").retrieve().bodyToFlux(String.class);
	}

}
