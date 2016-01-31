package com.example.nosqldemo.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.example.nosqldemo.domain.Computer;
import com.example.nosqldemo.service.ComputerManager;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class ComputerManagerTest {
	
	@Autowired
	ComputerManager computerManager;
	
	@After
	    public void usunTestowaneDane() {

		
	        List<Computer> computers = computerManager.getComputers();

	      
	        for(Computer computer : computers) {
	         
	         
	        
	        computerManager.dellComputer(computer);
	        	
	        }
	        
	    }
	 
	 
	@Test
	public void checkAdding(){
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

}
