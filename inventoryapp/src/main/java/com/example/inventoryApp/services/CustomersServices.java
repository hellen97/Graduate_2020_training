package com.example.inventoryApp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.inventoryApp.dao.CustomersJPADAO;
import com.example.inventoryApp.dao.OrdersJPADAO;
import com.example.inventoryApp.dao.ProductsJPADAO;
import com.example.inventoryApp.entities.Customers;
import com.example.inventoryApp.entities.Orders;

@Component
@Scope("singleton")
public class CustomersServices {
	
	String Exampleproperty;
	
	@Autowired
	CustomersServices cusSvc;
	
	@Autowired
	CustomersJPADAO cusdao;
	
	@Autowired
	OrdersJPADAO orddao;
	
	@Autowired
	ProductsServices prodSvc;
	
	@Autowired
	ProductsJPADAO proddao;
	

	
	public void exampleMethod() {
			System.out.println("connect to " +getExampleproperty()+ " for business data");
	}
	public String getExampleproperty() {
		return Exampleproperty;
	}

	public void setExampleproperty(String exampleproperty) {
		Exampleproperty = exampleproperty;
	}
	
	@Transactional
	public Customers assignCustomersToOrders(int custno, int orderno) {
		Customers cus = cusdao.findById(custno).get();
		Orders newOrders = orddao.findById(orderno).get();
		
		cus.setCurrentOrder(newOrders);
		newOrders.getCustomerOrders().add(cus);
		
		cusdao.save(cus);
		orddao.save(newOrders);
		
		return cus;
	}
	

}
