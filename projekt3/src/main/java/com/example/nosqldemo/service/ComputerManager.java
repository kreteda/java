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
	
	public void addNewComputer(Computer computer){
		computerRepository.save(computer);
	}
	public void dellComputer(Computer computer){
		computerRepository.delete(computer);
	}
	
	public List<Computer> getComputers(String make){
		return computerRepository.findByMake(make);
	}
	
	public List<Computer> getComputers(String make, String model){
		return computerRepository.znajdzKomputer(make, model);
	}
	
	public Computer getComputer(ObjectId id){
		return computerRepository.findById(id);
	}
	
	
	
}
