package com.example.inventoryApp.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.inventoryApp.dao.OrdersJPADAO;
import com.example.inventoryApp.dao.ProductsJPADAO;
import com.example.inventoryApp.entities.Orders;
import com.example.inventoryApp.entities.Products;

@Component
@Scope("singleton")
public class OrdersServices {
	
	
	@Autowired
	OrdersJPADAO orddao;
	
	@Autowired
	ProductsJPADAO proddao;
	
String Exampleproperty;
	
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
	public Orders assignOrderToProduct (int orderno, int prodno) {
		Orders ord = orddao.findById(orderno).get();
		Products prod = proddao.findById(prodno).get();
		
		ord.getproductsAssigned().add(prod);
		orddao.save(ord);
		
		return ord;
		
	}
	

}

