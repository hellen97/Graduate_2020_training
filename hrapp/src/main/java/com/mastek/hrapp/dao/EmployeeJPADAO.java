package com.mastek.hrapp.dao;

 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

 

import com.mastek.hrapp.entities.Employee;

 

@Repository //Declare the DAO layer as repository to manage data operations 
public interface EmployeeJPADAO extends
                CrudRepository<Employee, Integer>{                                     //Crud repository <class,PrimaryKeyType>

 

    
}
 