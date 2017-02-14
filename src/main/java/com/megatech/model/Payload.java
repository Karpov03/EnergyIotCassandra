package com.megatech.model;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;

//@Table(value = "payload")
public class Payload {

	@PrimaryKey("id")
	private long id;

	@Column("tag_name")
	private String name;

	@Column
	private String tag_code;

	@Column(value = "tag_desc")
	private String salary;

	/**
	 * Default Constructor
	 */
	public Payload() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag_code() {
		return tag_code;
	}

	public void setTag_code(String tag_code) {
		this.tag_code = tag_code;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Payload(long id, String name, String tag_code, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.tag_code = tag_code;
		this.salary = salary;
	}

}