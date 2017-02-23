package com.megatech.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.megatech.model.EnergyTimeSeries;

@org.springframework.stereotype.Repository
public interface CassandraRepo extends CassandraRepository<EnergyTimeSeries> {

	@Query("select * from energytimeseries where tagid in(?0) ALLOW FILTERING")
    Iterable<EnergyTimeSeries> findByTagid(List<Integer> tagid);

	@Query("select * from energytimeseries where value in(?0) ALLOW FILTERING")
    Iterable<EnergyTimeSeries> findByDate(List<Float> value);
	
	
}