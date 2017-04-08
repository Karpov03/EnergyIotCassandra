package com.megatech.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.megatech.model.EnergyTimeData;

@org.springframework.stereotype.Repository
public interface CassandraRepo extends CrudRepository<EnergyTimeData,Long> {

	@Query("select * from mclenergy where tagid in(?0) limit 10")
    Iterable<EnergyTimeData> findByTagid(List<String> tagid);

	@Query("SELECT * FROM mclenergy WHERE tagid IN (?0) AND timestamps >= ?1 AND timestamps <=?2")
    Iterable<EnergyTimeData> findByTagidInAndTimestamps(List<String> tagid,Long startTime, Long endTime);



	
}