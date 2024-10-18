package com.oracle.admissions_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/admissions")
public class AdmissionsResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/physicians")
	public EmployeeList getPhysicians() {
		EmployeeList physicians = restTemplate.getForObject("http://HR-SERVICES/hr/employees", EmployeeList.class);
		return physicians;
	}
	
	@RequestMapping("/healthissues")
	public DiseaseList getDisease() {
		DiseaseList diseases = restTemplate.getForObject("http://PATHOLOGY-SERVICES/pathology/diseases", DiseaseList.class);
		return diseases;
	}
}
