package com.example.nosqldemo.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import com.example.nosqldemo.domain.Computer;
import com.example.nosqldemo.domain.Person;
import com.example.nosqldemo.repository.ComputerRepository;
import com.example.nosqldemo.repository.PersonRepository;
@Component
public class ComputerManager {

	@Autowired
	private  ComputerRepository computerRepository;
	private  PersonRepository personRepository;
	
	public void addNewComputer(Computer computer){
		computerRepository.save(computer);
	}
	public void dellComputer(Computer computer){
		computerRepository.delete(computer);
	}
	public void dellPerson(Person person){
		personRepository.delete(person);
	}
	
	public long getAllUsers()
	{
		
		return personRepository.count();
		
	}
	
	public void dellComputersByMake(List<Computer> computers, String make){
		for(Computer computer:computers)
		{
			if(computer.getMake()==make)
			{
			computerRepository.delete(computer);
			}
		}
		
		
	}
	
	
	/*public List<Computer> dellComputersUserByMake(List<Computer> computers, String make){
		List<Computer> nowalista = new ArrayList<Computer>();
		for(Computer computer:computers)
		{
			if(computer.getMake()==make)
			{
			computerRepository.delete(computer);
			}
			else
			{
				nowalista.add(computer);
			}
		}
		return nowalista;
		
	} */
	
	public List<Computer> getComputers(String make){
		return computerRepository.findByMake(make);
	}
	

	
	public List<Computer> getComputers(){
		return (List<Computer>) computerRepository.findAll();
	}
	
	
	public List<Computer> getComputers(String make, String model){
		return computerRepository.znajdzKomputer(make, model);
	}
	
	public Computer getComputer(ObjectId id){
		return computerRepository.findById(id);
	}
	
	
	
}
