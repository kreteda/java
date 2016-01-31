package com.example.nosqldemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.example.nosqldemo.domain.Computer;
import com.example.nosqldemo.domain.Person;
import com.example.nosqldemo.service.ComputerManager;
import com.mongodb.DB;
 
 
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class ComputerManagerTest {
	
	@Autowired
	ComputerManager computerManager;
	@Autowired
	PersonRepository personManager;
	@Autowired
	ComputerRepository computerRepository;
	     
	   private List<ObjectId>  addedComputer = new ArrayList<ObjectId>();
	 @Before
	  public void sprawdzDodaneElementy() {

    
		 List<Computer> computers1 = computerManager.getComputers();
	 for(Computer computer : computers1)
     addedComputer.add(computer.getId());
 
    }
	
	@After
	

	    public void usunTestowaneDane() {
			personManager.deleteAll();
		
	        List<Computer> computers2 = computerManager.getComputers();

	      
	        for(Computer computer2 : computers2) {
	        	 for(ObjectId computer : addedComputer)
	        	 {
	        		 if (computer == computer2.getId())
                     {
	        			 
                     } 
	        		 else
	        		 {computerManager.dellComputer(computer2);
	        		 
	        		 }
	        	 }
	        	 computerManager.dellComputer(computer2);  /// usunąć
	        }
	        
	        
	       

		      
	         
	    }
	 
	 
	@Test
	public void checkAdding4(){
		Computer computer = new Computer();
		computer.setMake("HP");
		computer.setModel("6555p");
	 
		computerManager.addNewComputer(computer);
		
		Computer computer2 = new Computer();
		computer2.setMake("Fujitsu");
		computer2.setModel("S760");
	 
		computerManager.addNewComputer(computer2);
		
		Computer computer3 = new Computer();
		computer3.setMake("HP");
		computer3.setModel("6555p");
		 
		computerManager.addNewComputer(computer3);
		computerManager.dellComputer(computer3);
		
		List<Computer> computers = computerManager.getComputers("HP");
		
		assertTrue(computers.size() == 1);
	}
	
	
	
	@Test
	public void checkAdding2(){
		Computer computer = new Computer();
		computer.setMake("HP");
		computer.setModel("6555p");
	 
		computerManager.addNewComputer(computer);
		
		Computer computer2 = new Computer();
		computer2.setMake("Fujitsu");
		computer2.setModel("S760");
	 
		computerManager.addNewComputer(computer2);
		
		Computer computer3 = new Computer();
		computer3.setMake("HP");
		computer3.setModel("6555p");
		 
		computerManager.addNewComputer(computer3);
		
		
		List<Computer> computers = computerManager.getComputers("HP", "6555p");
		
		assertTrue(computers.size() == 2);
	}
	
	
	@Test
	public void checkAdding3(){
		Computer computer = new Computer();
		computer.setMake("HP");
		computer.setModel("6555p");
	 
		computerManager.addNewComputer(computer);
		
		Computer computer2 = new Computer();
		computer2.setMake("Fujitsu");
		computer2.setModel("S760");
	 
		computerManager.addNewComputer(computer2);
		
		Computer computer3 = new Computer();
		computer3.setMake("HP");
		computer3.setModel("6555p");
		 
		computerManager.addNewComputer(computer3);
		
		
		List<Computer> computers = computerManager.getComputers("HP", "6555p");
		
		assertTrue(computers.size() == 2);
	}

	
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
		p1.setSurname("Staszczyk");
		
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
		
	 
		
		List<Computer> computers = new ArrayList<Computer>();
		computers.add(c1);
		computers.add(c2);
		computers.add(c3);
		 
		p1.setComputers(computers); 
		
		 
 		
		personManager.save(p1);
     
		Person aGirl = personManager.findById(p1.getId());
	    
 
	  List<Computer> computers3 = new ArrayList<Computer>(aGirl.getComputers());
	
	assertTrue(computers3.size() == 3);
	 
	}
	
 
	
	
}
