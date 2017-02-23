package com.megatech.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.megatech.model.EnergyTimeData;

@org.springframework.stereotype.Repository
public interface CassandraRepo extends CrudRepository<EnergyTimeData,Long> {

	@Query("select * from energytimedata where tagid in(?0) ALLOW FILTERING")
    Iterable<EnergyTimeData> findByTagid(List<Integer> tagid);


	//@Query("select * from energytimedata where tagid in (?0) and timestamps in(?1,?2)")
	
	@Query("SELECT * FROM energytimedata WHERE tagid IN (?0) AND timestamps > ?1 AND timestamps <=?2")
    Iterable<EnergyTimeData> findByTagidInAndTimestamps(List<Integer> tagid,Long startTime, Long endTime);



	
}