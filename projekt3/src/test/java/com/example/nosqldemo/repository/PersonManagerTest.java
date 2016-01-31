package com.example.nosqldemo.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.nosqldemo.service.PersonManager;
import com.example.nosqldemo.domain.Computer;
import com.example.nosqldemo.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class PersonManagerTest {
	
	@Autowired
	PersonRepository personManager;
	@Autowired
	ComputerRepository computerRepository;
	
	@Test   /// dodawanie komputerów
	public void checkAdding(){
		
		Person p1 = new Person();
		p1.setName("Gosia");
		
		Computer c1 = new Computer();
		c1.setMake("Toyota");
		c1.setModel("Yaris");
		computerRepository.save(c1);
		
		
		Computer c2 = new Computer();
		c2.setMake("Honda");
		c2.setModel("Accord");
		computerRepository.save(c2);
		
		List<Computer> computers = new ArrayList<Computer>();
		computers.add(c1);
		computers.add(c2);
		
		p1.setComputers(computers);
		
		
		personManager.save(p1);
		
		Person aGirl = personManager.findById(p1.getId());
		
		
		assertEquals(2, aGirl.getComputers().size());
		
		
	}
	
	
	@Test   /// zmiana producenta komputera
	public void checkChanging(){
		
		Person p1 = new Person();
		p1.setName("Gosia");
		
		Computer c1 = new Computer();
		c1.setMake("Apple");
		c1.setModel("32323");
		computerRepository.save(c1);
		
		
		Computer c2 = new Computer();
		c2.setMake("HP");
		c2.setModel("2323");
		computerRepository.save(c2);
		
		List<Computer> computers = new ArrayList<Computer>();
		computers.add(c1);
		computers.add(c2);
	 
		p1.setComputers(computers);
		
 		
		personManager.save(p1);
		
		 
		Person aGirl = personManager.findById(p1.getId());
		List<Computer> retriverdComputers = new ArrayList<Computer>(aGirl.getComputers());
		  for(Computer computer : retriverdComputers)
	           
		  if(computer.getId()==c1.getId())
		  {
			  computer.setMake(c2.getMake());
		  }
	     
 
	List<Computer> computers2 = new ArrayList<Computer>(aGirl.getComputers());
	
	assertTrue(computers2.size() == 2);
	 
	}
	
	
	@Test   /// usuwanie komputera
	public void checkDeleting(){
		
		Person p1 = new Person();
		p1.setName("Gosia");
		
		Computer c1 = new Computer();
		c1.setMake("Apple");
		c1.setModel("32323");
		computerRepository.save(c1);
		
		
		Computer c2 = new Computer();
		c2.setMake("HP");
		c2.setModel("2323");
		computerRepository.save(c2);
		
		Computer c3 = new Computer();
		c3.setMake("HP");
		c3.setModel("2323");
		computerRepository.save(c3);
		
		String make="HP";
		
		List<Computer> computers = new ArrayList<Computer>();
		computers.add(c1);
		computers.add(c2);
		computers.add(c3);
		p1.setComputers(computers);
		
		 
 		
		personManager.save(p1);
		
		 
		Person aGirl = personManager.findById(p1.getId());
		List<Computer> retriverdComputers = new ArrayList<Computer>(aGirl.getComputers());
		  
		
		
 		aGirl.setComputers(aGirl.dellComputers(retriverdComputers,make));
 		
 		personManager.save(aGirl);
		 
		 
 
	List<Computer> computers3 = new ArrayList<Computer>(aGirl.getComputers());
	
	assertTrue(computers3.size() == 3);
	 
	}


	 

 
	

}
