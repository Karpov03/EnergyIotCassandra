package com.megatech.model;

import java.util.Date;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "mclenergy")
public class EnergyTimeData {

	@PrimaryKeyColumn(name = "timestamps", type = PrimaryKeyType.PARTITIONED)
	private Date timestamps;

	@PrimaryKeyColumn(name = "tagid")
	private String tagid;

	@PrimaryKeyColumn(name = "value")
	private float value;

	public EnergyTimeData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Date getTimestamps() {
		return timestamps;
	}

	/**
	 * @param timestamps the timestamps to set
	 */
	public void setTimestamps(Date timestamps) {
		this.timestamps = timestamps;
	}

	/**
	 * @return the tagid
	 */
	public String getTagid() {
		return tagid;
	}

	/**
	 * @param tagid the tagid to set
	 */
	public void setTagid(String tagid) {
		this.tagid = tagid;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public EnergyTimeData(Date timestamps, String tagid, float value) {
		super();
		this.timestamps = timestamps;
		this.tagid = tagid;
		this.value = value;
	}

}
