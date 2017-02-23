package com.megatech.model;

import java.util.Date;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "energytimedata")
public class EnergyTimeData {

	@PrimaryKeyColumn(name = "timestamps", type = PrimaryKeyType.PARTITIONED)
	private Date timestamps;

	@PrimaryKeyColumn(name = "tagid")
	private Integer tagid;

	@PrimaryKeyColumn(name = "value")
	private float value;

	public EnergyTimeData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getEnergytime() {
		return timestamps;
	}

	public void setEnergytime(Date energytime) {
		this.timestamps = energytime;
	}

	public Integer getTagid() {
		return tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public EnergyTimeData(Date timestamps, Integer tagid, float value) {
		super();
		this.timestamps = timestamps;
		this.tagid = tagid;
		this.value = value;
	}

}
