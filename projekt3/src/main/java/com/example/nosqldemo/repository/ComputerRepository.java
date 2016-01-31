package com.example.nosqldemo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.nosqldemo.domain.Computer;

public interface ComputerRepository extends CrudRepository<Computer, ObjectId>{
	
	List<Computer> findByMake(String make);
	
	List<Computer> findByYop(int yop);
	
	@Query(value = "{ 'make' : ?0, 'model' : ?1 }" )
	List<Computer> znajdzKomputer(String make, String model);
	
	@Query(value = "{ 'make' : ^?HP}" )
	List<Computer> znajdzKomputer2(); 
	
	Computer findById(ObjectId id);

}
