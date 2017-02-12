package com.megatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megatech.model.Payload;
import com.megatech.repo.CassandraRepo;

@Service
public class EnergyService {

	@Autowired
	CassandraRepo cassandraRepo;

	@Transactional
	public Iterable<Payload> getTag(List<?> id) {
		return cassandraRepo.findById(id);
	}

	@Transactional
	public Iterable<Payload> getAllTag() {
		return cassandraRepo.findAll();
	}

}