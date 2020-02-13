package com.example.inventoryApp.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ProductsServices {

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
}
