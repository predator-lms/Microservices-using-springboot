package com.oracle.pathology_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PathologyServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathologyServicesApplication.class, args);
	}

}
