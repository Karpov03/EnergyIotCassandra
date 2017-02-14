package com.megatech.model;

import java.util.Date;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "energyiot")
public class EnergyIot {

	@PrimaryKey("energytime")
	private Date energytime;

	@Column(value = "tagid")
	private String tagid;

	@Column(value = "value")
	private float value;

	public EnergyIot() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getEnergytime() {
		return energytime;
	}

	public void setEnergytime(Date energytime) {
		this.energytime = energytime;
	}

	public String getTagid() {
		return tagid;
	}

	public void setTagid(String tagid) {
		this.tagid = tagid;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public EnergyIot(Date energytime, String tagid, float value) {
		super();
		this.energytime = energytime;
		this.tagid = tagid;
		this.value = value;
	}

	
}
