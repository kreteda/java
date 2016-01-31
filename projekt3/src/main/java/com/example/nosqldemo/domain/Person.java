package com.example.nosqldemo.domain;

import java.util.List;

import org.bson.types.ObjectId;

public class Person {

	private ObjectId id;
	private String name;
	
	private List<Computer> computers;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Computer> getCars() {
		return computers;
	}

	public void setCars(List<Computer> computers) {
		this.computers = computers;
	}
	
	
}
