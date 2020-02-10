package com.mastek.inventoryapp.services;

 

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;

public class CategoryServices {
String exampleProduct;
    
    public CategoryServices() {
        System.out.println("Category Service Created");
    }
    
    @PostConstruct // Initialisation method of the class 
    public void initalizeService() {
        System.out.println("Category Service Initialized");
    }
    
    @PreDestroy // calls before the shutting down of the application
    public void terminateService() {
        System.out.println("Category Service Terminated");
    }
    
    public void exampleMethod() {
        System.out.println("Connect to "+ getExampleProperty()+ " for category data");
    }
    
    public String getExampleProperty() {
        return exampleProduct;
    }

 

    @Value("Spring Example Data Source")    // if you don't set the value the property will not be set 
    public void setExampleProduct(String exampleProduct) {
        System.out.println("Example Property Set :"+exampleProduct);
        this.exampleProduct = exampleProduct;
    }
    
}