package com.megatech.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatech.model.EnergyIot;

@Repository
public interface CassandraRepo extends CassandraRepository<EnergyIot> {

	@Query("select * from energytimeseries where tagid in(?0)")
	Iterable<EnergyIot> findByTagid(List<?> tagid);
}