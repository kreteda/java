package com.example.nosqldemo.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.nosqldemo.domain.Computer;
import com.example.nosqldemo.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class PersonManagerTest {
	
	@Autowired
	PersonRepository personManager;
	@Autowired
	ComputerRepository computerRepository;
	
	@Test
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
		
		p1.setCars(computers);
		
		
		personManager.save(p1);
		
		Person aGirl = personManager.findById(p1.getId());
		
		assertEquals(2, aGirl.getCars().size());
		
		
	}

}
