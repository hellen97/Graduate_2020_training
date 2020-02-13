package com.example.inventoryApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.inventoryApp.entities.Category;


@Repository
public interface CategoryJPADAO extends CrudRepository<Category, Integer> {

}