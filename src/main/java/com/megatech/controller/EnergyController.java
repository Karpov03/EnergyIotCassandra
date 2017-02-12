package com.megatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatech.model.Payload;
import com.megatech.service.EnergyService;

@RestController
@RequestMapping(value = "/tags")
public class EnergyController {

	@Autowired
	private EnergyService energyService;

	public EnergyController() {
		System.out.println("EnergyController()");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "Welcome to EnergyIOt Site, It's developed Using Spring Boot and Cassandra";
	}
	
	// ################ get Entire Tag ####################
		@RequestMapping(value = "/getTag", method = RequestMethod.GET)
		public Iterable<Payload> getEntireTAg() {
			System.out.println("Get Entire Tag");
			return energyService.getAllTag();
		}

	// ################ get Tag by Id ####################
	@RequestMapping(value = "/getTag/{tagId}", method = RequestMethod.GET)
	public Iterable<Payload> getTagsById(@PathVariable List<Long> tagId) {
		System.out.println("Get Tag By Given ID");
		return energyService.getTag(tagId);
	}
}