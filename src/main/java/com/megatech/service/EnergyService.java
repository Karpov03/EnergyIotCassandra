package com.megatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megatech.model.EnergyTimeData;
import com.megatech.repo.CassandraRepo;

@Service
public class EnergyService {

	@Autowired
	CassandraRepo cassandraRepo;

	@Transactional
	public Iterable<EnergyTimeData> getTag(List<String> tagid) {
		return cassandraRepo.findByTagid(tagid);
	}

	@Transactional
	public List<EnergyTimeData> getTagByDate(List<String> tagid,Long startdate,Long enddate) {
		return cassandraRepo.findByTagidInAndTimestamps(tagid, startdate, enddate);
	}

	@Transactional
	public Iterable<EnergyTimeData> getTimeData() {
		return cassandraRepo.findAll();
	}

}