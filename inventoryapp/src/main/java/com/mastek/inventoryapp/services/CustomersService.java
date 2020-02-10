package com.mastek.inventoryapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.inventoryapp.dao.CategoryJPADAO;
import com.mastek.inventoryapp.dao.CutomersJPADAO;
import com.mastek.inventoryapp.dao.ProductsJPADAO;
import com.mastek.inventoryapp.entities.Category;
import com.mastek.inventoryapp.entities.Customers;
import com.mastek.inventoryapp.entities.Products;

@Component //marking the class as bean to be created
@Scope("singleton") // singleton:One object used across test cases, prototype: one object per request
public class CustomersService {

	String exampleProduct;
	
	@Autowired
	CutomersJPADAO cusDAO;
	
	@Autowired
	CategoryJPADAO catDAO;
	
	@Autowired
	ProductsJPADAO proDAO; 
	
	
	
	
	public CustomersService() {
		System.out.println("Customer Service Created");
	}

	@PostConstruct // initialization method of the class
	public void initalizeService() {
		System.out.println("Customer Service Initialized");
	}

	@PreDestroy // calls before the shutting down the application
	public void terminateService() {
		System.out.println("Customer Service Terminated");
	}
	
	
	public void exampleMethod() {
		System.out.println("Connect to "+getExampleProduct()+" for product data");
	}
	
	public String getExampleProduct() {
		return exampleProduct;
	}

	@Value("Spring Example Data Source") // initialize the property with the simple value
	public void setExampleProduct(String exampleProduct) {
		System.out.println("Example Product Set :"+exampleProduct);
		this.exampleProduct = exampleProduct;
	}
	
	
	@Transactional 
	public Customers assignCustomersToProduct(int cusno, int prono) {
	
		Customers cus = cusDAO.findById(cusno).get();
		Products prod = proDAO.findById(prono).get();
		
		//assign the assoication between and department
		cus.setCurrentCategory(prod);  // assign the department to employee
		prod.getProjectTeam().add(cus);	    // add the employee in the department team 
		
		
		// save the changes in database 
		cusDAO.save(cus);
		proDAO.save(prod);
		
		return cus; // return the result 
	}
	
}
