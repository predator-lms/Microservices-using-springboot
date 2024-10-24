package com.oracle.FirstExample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondEndPoint {
	
	@Autowired
	private UserDaoService services;
	
	@RequestMapping("/getAllUsers")
	public List<User> retreiveAllUser(){
		return services.findAll();
	}
}
