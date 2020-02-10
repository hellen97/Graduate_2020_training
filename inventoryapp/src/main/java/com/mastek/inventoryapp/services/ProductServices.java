    
package com.mastek.inventoryapp.services;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;


@Component
@Scope("singleton")
public class ProductServices {
    
String exampleProduct;
    
    public ProductServices() {
        System.out.println("Product Service Created");
    }
    
    @PostConstruct // Initialisation method of the class 
    public void initalizeService() {
        System.out.println("Product Service Initialized");
    }
    
    @PreDestroy // calls before the shutting down of the application
    public void terminateService() {
        System.out.println("Product Service Terminated");
    }
    
    public void exampleMethod() {
        System.out.println("Connect to "+ getExampleProduct()+ " for business data");
    }
    
    public String getExampleProduct() {
        return exampleProduct;
    }


    @Value("Spring Example Data Source")    // if you don't set the value the property will not be set 
    public void setExampleProperty(String exampleProperty) {
        System.out.println("Example Property Set :"+exampleProduct);
        this.exampleProduct = exampleProduct;
    }
    
}







