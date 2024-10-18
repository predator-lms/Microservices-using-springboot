package com.oracle.hr_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HrServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrServicesApplication.class, args);
	}

}
