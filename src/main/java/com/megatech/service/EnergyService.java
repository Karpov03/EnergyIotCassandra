package com.megatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megatech.model.EnergyTimeSeries;
import com.megatech.repo.CassandraRepo;

@Service
public class EnergyService {

	@Autowired
	CassandraRepo cassandraRepo;

	@Transactional
	public Iterable<EnergyTimeSeries> getTag(List<Integer> tagid) {
		return cassandraRepo.findByTagid(tagid);
	}
	@Transactional
	public Iterable<EnergyTimeSeries> getValue(List<Float> value) {
		return cassandraRepo.findByValue(value);
	}

	@Transactional
	public Iterable<EnergyTimeSeries> getTimeData() {
		return cassandraRepo.findAll();
	}

}