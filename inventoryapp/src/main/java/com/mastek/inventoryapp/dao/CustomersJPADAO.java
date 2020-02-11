package com.mastek.inventoryapp.dao;

 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

 

import com.mastek.inventoryapp.entities.Customers;

 

@Repository //Declare the DAO layer as repository to manage data operations 
public interface CustomersJPADAO extends
                CrudRepository<Customers, Integer>{                                     //Crud repository <class,PrimaryKeyType>

 

    
}
 