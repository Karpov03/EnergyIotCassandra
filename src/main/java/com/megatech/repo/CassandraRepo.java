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

	@Query("select avg(value) from mclenergy where tagid in(?0)")
  Double avgByTagid(List<String> tagid);

	@Query("SELECT avg(value) FROM mclenergy WHERE tagid IN (?0) AND timestamps >= ?1 AND timestamps <=?2")
  Double avgByTagidInAndTimestamps(List<String> tagid,Long startTime, Long endTime);

	@Query("select count(value) from mclenergy where tagid in(?0)")
  Double countByTagid(List<String> tagid);

	@Query("SELECT count(value) FROM mclenergy WHERE tagid IN (?0) AND timestamps >= ?1 AND timestamps <=?2")
  Double countByTagidInAndTimestamps(List<String> tagid,Long startTime, Long endTime);

	@Query("select min(value) from mclenergy where tagid in(?0)")
  Double minByTagid(List<String> tagid);

	@Query("SELECT min(value) FROM mclenergy WHERE tagid IN (?0) AND timestamps >= ?1 AND timestamps <=?2")
  Double minByTagidInAndTimestamps(List<String> tagid,Long startTime, Long endTime);

	@Query("select max(value) from mclenergy where tagid in(?0)")
  Double maxByTagid(List<String> tagid);

	@Query("SELECT max(value) FROM mclenergy WHERE tagid IN (?0) AND timestamps >= ?1 AND timestamps <=?2")
  Double maxByTagidInAndTimestamps(List<String> tagid,Long startTime, Long endTime);

	@Query("select sum(value) from mclenergy where tagid in(?0)")
  Double sumByTagid(List<String> tagid);

	@Query("SELECT sum(value) FROM mclenergy WHERE tagid IN (?0) AND timestamps >= ?1 AND timestamps <=?2")
  Double sumByTagidInAndTimestamps(List<String> tagid,Long startTime, Long endTime);

	


	
}