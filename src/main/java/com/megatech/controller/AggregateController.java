package com.megatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatech.service.AggregateService;

@RestController
@RequestMapping(value = "/logics")
public class AggregateController {

	@Autowired
	private AggregateService aggService;

	public AggregateController() {
		System.out.println("AggregateController()");
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String index() {
		return "Aggregate Function on this link";
	}

	// ################ get Average Value by Given Tag ####################
	@RequestMapping(value = "/avg/{tagId}", method = RequestMethod.GET)
	public Double getAvgbyTagId(@PathVariable List<String> tagId) {
		System.out.println("Get Average Value Tag By Given ID");
		Double avg = aggService.getAvg(tagId);
		return avg;
	}

	// ################ get Average Value by Given Tag between Dates//
	// ####################
	@RequestMapping(value = "/avg/{tagid}/{startdate}/{enddate}", method = RequestMethod.GET)
	public Double getAvgByDate(@PathVariable List<String> tagid, @PathVariable Long startdate,
			@PathVariable Long enddate) {
		System.out.println("get Average Value by Given Tag between Dates");
		return aggService.getAvgByDate(tagid, startdate, enddate);
	}

	// ################ get Sum Value by Given Tag ####################
	@RequestMapping(value = "/sum/{tagId}", method = RequestMethod.GET)
	public Double getSumbyTagId(@PathVariable List<String> tagId) {
		System.out.println("Get Average Value Tag By Given ID");
		return aggService.getSum(tagId);
	}

	// ################ get Sum Value by Given Tag between Dates//
	// ####################
	@RequestMapping(value = "/sum/{tagid}/{startdate}/{enddate}", method = RequestMethod.GET)
	public Double getSumByDate(@PathVariable List<String> tagid, @PathVariable Long startdate,
			@PathVariable Long enddate) {
		System.out.println("get Sum Value by Given Tag between Dates");
		return aggService.getSumByDate(tagid, startdate, enddate);
	}

	// ################ get Count Value by Given Tag ####################
	@RequestMapping(value = "/count/{tagId}", method = RequestMethod.GET)
	public Double getCountbyTagId(@PathVariable List<String> tagId) {
		System.out.println("Get Count Value Tag By Given ID");
		return aggService.getCount(tagId);
	}

	// ################ get Count Value by Given Tag between Dates//
	// ####################
	@RequestMapping(value = "/count/{tagid}/{startdate}/{enddate}", method = RequestMethod.GET)
	public Double getCountByDate(@PathVariable List<String> tagid, @PathVariable Long startdate,
			@PathVariable Long enddate) {
		System.out.println("get Count Value by Given Tag between Dates");
		return aggService.getCountByDate(tagid, startdate, enddate);
	}

	// ################ get Minimum Value by Given Tag ####################
	@RequestMapping(value = "/min/{tagId}", method = RequestMethod.GET)
	public Double getMinbyTagId(@PathVariable List<String> tagId) {
		System.out.println("Get Minimum Value Tag By Given ID");
		return aggService.getMin(tagId);
	}

	// ################ get Minimum Value by Given Tag between Dates//
	// ####################
	@RequestMapping(value = "/min/{tagid}/{startdate}/{enddate}", method = RequestMethod.GET)
	public Double getMinByDate(@PathVariable List<String> tagid, @PathVariable Long startdate,
			@PathVariable Long enddate) {
		System.out.println("get Minimum Value by Given Tag between Dates");
		return aggService.getMinByDate(tagid, startdate, enddate);
	}

	// ################ get Maximum Value by Given Tag ####################
	@RequestMapping(value = "/max/{tagId}", method = RequestMethod.GET)
	public Double getMaxbyTagId(@PathVariable List<String> tagId) {
		System.out.println("Get Maximum Value Tag By Given ID");
		return aggService.getMax(tagId);
	}

	// ################ get Maximum Value by Given Tag between Dates//
	// ####################
	@RequestMapping(value = "/max/{tagid}/{startdate}/{enddate}", method = RequestMethod.GET)
	public Double getMaxByDate(@PathVariable List<String> tagid, @PathVariable Long startdate,
			@PathVariable Long enddate) {
		System.out.println("get Maximum Value by Given Tag between Dates");
		return aggService.getMaxByDate(tagid, startdate, enddate);
	}

}