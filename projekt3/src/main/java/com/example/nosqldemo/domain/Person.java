package com.example.nosqldemo.domain;

import java.util.ArrayList;
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

	public List<Computer> getComputers() {
		return computers;
	}

	public void setComputers(List<Computer> computers) {
		this.computers = computers;
	}
	
	public List<Computer> dellComputers(List<Computer> computers,String make) {
		List<Computer> computers3 = new ArrayList<Computer>();
		for(Computer computer2 : computers)
		{
			if(computer2.getMake()!=make)
			{
				computers3.add(computer2);
			}
		}
		return this.computers = computers3;
		
	}
	
}
