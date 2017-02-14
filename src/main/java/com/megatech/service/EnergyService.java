package com.megatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megatech.model.EnergyIot;
import com.megatech.repo.CassandraRepo;

@Service
public class EnergyService {

	@Autowired
	CassandraRepo cassandraRepo;

	@Transactional
	public Iterable<EnergyIot> getTag(List<?> tagid) {
		return cassandraRepo.findByTagid(tagid);
	}

	@Transactional
	public Iterable<EnergyIot> getTimeData() {
		return cassandraRepo.findAll();
	}

}