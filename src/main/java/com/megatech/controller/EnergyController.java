package com.megatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatech.model.EnergyTimeSeries;
import com.megatech.service.EnergyService;

@RestController
@RequestMapping(value = "/tags")
public class EnergyController {

	@Autowired
	private EnergyService energyService;

	public EnergyController() {
		System.out.println("EnergyController()");
	}

	@RequestMapping(value ={ "/",""}, method = RequestMethod.GET)
	public String index() {
		return "Welcome to EnergyIOt Site, It's developed Using Spring Boot and Cassandra";
	}
	
	// ################ get Entire Tag ####################
		@RequestMapping(value = "/gettimedata", method = RequestMethod.GET)
		public Iterable<EnergyTimeSeries> getTimeData() {
			System.out.println("Get Entire Tag");
			return energyService.getTimeData();
		}

		// ################ get Tag by Id ####################
		@RequestMapping(value = "/gettag/{tagId}", method = RequestMethod.GET)
		public Iterable<EnergyTimeSeries> getTagsById(@PathVariable List<Integer> tagId) {
			System.out.println("Get Tag By Given ID");
			return energyService.getTag(tagId);
		}
		// ################ get Value ####################
		@RequestMapping(value = "/getvalue/{valueId}", method = RequestMethod.GET)
		public Iterable<EnergyTimeSeries> getValue(@PathVariable List<Float> valueId) {
			System.out.println("Get Tag By Given VALUE");
			return energyService.getValue(valueId);
		}
}