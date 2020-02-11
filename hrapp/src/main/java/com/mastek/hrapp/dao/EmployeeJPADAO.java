package com.mastek.hrapp.dao;

 

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;

 

@Repository //Declare the DAO layer as repository to manage data operations 
public interface EmployeeJPADAO extends
                CrudRepository<Employee, Integer>{

	Iterable<Employee> findBySalary(@Param("minSalary") double minSalary,@Param("maxSalary") double maxSalary);                                     //Crud repository <class,PrimaryKeyType>

	Iterable<Employee> findByDesignation(@Param("designation")Designation designation); // define the methods for each name query in the entity
	// mapp each parameter with @param(<name>) 

    
}
 