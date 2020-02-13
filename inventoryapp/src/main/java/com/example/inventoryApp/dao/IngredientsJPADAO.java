package com.example.inventoryApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryApp.entities.Ingredients;


@Repository
public interface IngredientsJPADAO extends CrudRepository<Ingredients, Integer>{

}
