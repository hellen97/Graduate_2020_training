package com.example.inventoryApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryApp.entities.Customers;



@Repository
public interface CustomersJPADAO extends  CrudRepository<Customers, Integer> {
			 
}