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
	List<Computer> znajdzAuto(String make, String model);
	
	Computer findById(ObjectId id);

}
