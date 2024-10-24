package com.oracle.pathology_services;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {

	public PathologyResource() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	List<Disease> diseases = Arrays.asList(
			new Disease("D1", "Dengue", "Be Safe from still water."),
			new Disease("D2", "Headache", "Hot water vapor."),
			new Disease("D3", "Corona", "Wash hands and stay safe.")
			);
	
	@RequestMapping("/diseases")
	public DiseaseList diseases() {
		DiseaseList disList = new DiseaseList();
		disList.setDiseases(diseases);
		return disList;
	}
	
	@RequestMapping("/diseases/{id}")
	public Disease getDiseasebyId(@PathVariable("id") String id) {
		Disease d = diseases.stream().filter(dea -> id.equals(dea.getId())).findAny().orElse(null);
		
		return d;
	}

}
