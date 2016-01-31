package com.example.nosqldemo.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.nosqldemo.domain.Computer;
import com.example.nosqldemo.service.ComputerManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class ComputerManagerTest {
	
	@Autowired
	ComputerManager computerManager;
	
	@Test
	public void checkAdding(){
		Computer computer = new Computer();
		computer.setMake("Ford");
		computer.setModel("Fiesta");
		computer.setYop(1998);
		computerManager.addNewCar(computer);
		
		Computer computer2 = new Computer();
		computer2.setMake("Ford");
		computer2.setModel("Focus");
		computer2.setYop(1998);
		computerManager.addNewCar(computer2);
		
		Computer computer3 = new Computer();
		computer3.setMake("Fiat");
		computer3.setModel("Punto");
		computer3.setYop(2011);
		computerManager.addNewCar(computer3);
		
		List<Computer> computers = computerManager.getCars("Ford");
		
		assertTrue(computers.size() >= 2);
	}

}
