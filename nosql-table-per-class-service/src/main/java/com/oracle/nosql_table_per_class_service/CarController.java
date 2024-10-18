package com.oracle.nosql_table_per_class_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.nosql_table_per_class_service.models.Car;
import com.oracle.nosql_table_per_class_service.repositories.CarMongoRepository;
import com.oracle.nosql_table_per_class_service.repositories.CarSearchRepository;


@Controller
public class CarController {

	public CarController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	CarMongoRepository carMongoRepo;
	
	@Autowired
	CarSearchRepository carSearchRepo;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("carList", carMongoRepo.findAll());
		
		return "home";
	}
	
	@RequestMapping(value="/addCar", method=RequestMethod.POST)
	public String addCar(@ModelAttribute Car car) {
		carMongoRepo.save(car);
		
		return "redirect:home";
	}
	
	@RequestMapping(value="/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("carList", carSearchRepo.searchCars(search));
		model.addAttribute("search", search);
		
		return "home";
	}
}
