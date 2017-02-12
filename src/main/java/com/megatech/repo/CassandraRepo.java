package com.megatech.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.megatech.model.Payload;

@Repository
public interface CassandraRepo extends CassandraRepository<Payload> {

	@Query("select * from payload where id in(?0)")
	Iterable<Payload> findById(List<?> id);
}