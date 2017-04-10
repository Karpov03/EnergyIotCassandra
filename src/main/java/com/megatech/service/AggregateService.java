package com.megatech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.megatech.repo.CassandraRepo;

@Service
public class AggregateService {

	@Autowired
	CassandraRepo cassandraRepo;

	@Transactional
	public Double getAvg(List<String> tagId) {
		return cassandraRepo.avgByTagid(tagId);
	}

	@Transactional
	public Double getAvgByDate(List<String> tagId, Long startTime, Long endTime) {
		return cassandraRepo.avgByTagidInAndTimestamps(tagId, startTime, endTime);
	}

	@Transactional
	public Double getSum(List<String> tagId) {
		return cassandraRepo.sumByTagid(tagId);
	}

	@Transactional
	public Double getSumByDate(List<String> tagId, Long startTime, Long endTime) {
		return cassandraRepo.sumByTagidInAndTimestamps(tagId, startTime, endTime);
	}

	@Transactional
	public Double getMin(List<String> tagId) {
		return cassandraRepo.minByTagid(tagId);
	}

	@Transactional
	public Double getMinByDate(List<String> tagId, Long startTime, Long endTime) {
		return cassandraRepo.minByTagidInAndTimestamps(tagId, startTime, endTime);
	}

	@Transactional
	public Double getMax(List<String> tagId) {
		return cassandraRepo.maxByTagid(tagId);
	}

	@Transactional
	public Double getMaxByDate(List<String> tagId, Long startTime, Long endTime) {
		return cassandraRepo.maxByTagidInAndTimestamps(tagId, startTime, endTime);
	}

	@Transactional
	public Double getCount(List<String> tagId) {
		return cassandraRepo.countByTagid(tagId);
	}

	@Transactional
	public Double getCountByDate(List<String> tagId, Long startTime, Long endTime) {
		return cassandraRepo.countByTagidInAndTimestamps(tagId, startTime, endTime);
	}

}