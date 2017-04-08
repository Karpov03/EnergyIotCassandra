package com.megatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatech.model.EnergyTimeData;
import com.megatech.service.EnergyService;

@RestController
@RequestMapping(value = "/tags")
public class EnergyController {

	@Autowired
	private EnergyService energyService;

	public EnergyController() {
		System.out.println("EnergyController()");
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index() {
		return "Welcome to EnergyIOt Site, It's developed Using Spring Boot and Cassandra";
	}

	// ################ get Entire Tag ####################
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	public Iterable<EnergyTimeData> getTimeData() {
		System.out.println("Get Entire Tag");
		return energyService.getTimeData();
	}

	// ################ get Tag by Id ####################
	@RequestMapping(value = "/gettag/{tagId}", method = RequestMethod.GET)
	public Iterable<EnergyTimeData> getTagsById(@PathVariable List<String> tagId) {
		System.out.println("Get Tag By Given ID");
		return energyService.getTag(tagId);
	}

	// ################ get Tag Value between Dates by tagId
	// ####################
	@RequestMapping(value = "/gettag/{tagid}/{startdate}/{enddate}", method = RequestMethod.GET)
	public Iterable<EnergyTimeData> getTagByDate(@PathVariable List<String> tagid, @PathVariable Long startdate,
			@PathVariable Long enddate) {
		System.out.println("get Tag Value between Dates by tagid");
		return energyService.getTagByDate(tagid, startdate, enddate);
	}

}