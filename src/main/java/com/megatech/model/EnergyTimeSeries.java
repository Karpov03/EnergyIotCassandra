package com.megatech.model;

import java.util.Date;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "energytimeseries")
public class EnergyTimeSeries {

	@PrimaryKeyColumn(name = "energytime", ordinal = 2, type = PrimaryKeyType.PARTITIONED)
	private Date energytime;

	@PrimaryKeyColumn(name = "tagid", ordinal = 0, type = PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
	private Integer tagid;

	@PrimaryKeyColumn(name = "value", ordinal = 0, type = PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
	private float value;

	public EnergyTimeSeries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getEnergytime() {
		return energytime;
	}

	public void setEnergytime(Date energytime) {
		this.energytime = energytime;
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

	public EnergyTimeSeries(Date energytime, Integer tagid, float value) {
		super();
		this.energytime = energytime;
		this.tagid = tagid;
		this.value = value;
	}

}
