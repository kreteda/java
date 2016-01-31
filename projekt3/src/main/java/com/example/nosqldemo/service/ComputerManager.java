package com.example.nosqldemo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.Computer;
import com.example.nosqldemo.repository.ComputerRepository;

@Component
public class ComputerManager {

	@Autowired
	private  ComputerRepository computerRepository;
	
	public void addNewCar(Computer computer){
		computerRepository.save(computer);
	}
	
	public List<Computer> getCars(String make){
		return computerRepository.findByMake(make);
	}
	
	public List<Computer> getCars(String make, String model){
		return computerRepository.znajdzAuto(make, model);
	}
	
	public Computer getCar(ObjectId id){
		return computerRepository.findById(id);
	}
	
	
	
}
