package com.example.inventoryApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryApp.entities.Orders;

@Repository
public interface OrdersJPADAO extends  CrudRepository<Orders, Integer> {
		 
	}
