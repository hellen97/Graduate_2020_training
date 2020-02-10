package com.mastek.inventoryapp.dao;

 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

 

import com.mastek.inventoryapp.entities.Category;

 

@Repository
public interface CategoryJPADAO extends
                 CrudRepository<Category, Integer>{

 

}