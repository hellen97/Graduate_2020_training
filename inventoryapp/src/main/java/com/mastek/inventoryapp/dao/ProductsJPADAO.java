package com.mastek.inventoryapp.dao;

 

import org.springframework.data.repository.CrudRepository;

 

import com.mastek.inventoryapp.entities.Products;

 

public interface ProductsJPADAO extends
                 CrudRepository<Products, Integer>{

 

}