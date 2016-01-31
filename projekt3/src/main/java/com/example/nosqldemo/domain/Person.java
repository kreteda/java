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
	
 
	public void dellComputersByMake(List<Computer> computers,String make) {
		//this.computers = computers;
		List<Computer> comps =  new ArrayList<Computer>();
		
		for(Computer computer:computers)
		{
			if(computer.getMake()!=make)
			{
			comps.add(computer);
			}
		}
		this.computers=comps;
	}
	
	 
	
}
