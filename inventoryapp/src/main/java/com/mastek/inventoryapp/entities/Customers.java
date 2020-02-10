package com.mastek.inventoryapp.entities;

 

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 

@Entity // declares the class as entity, to be managed by JPA
@Table(name="JPA_Customers") // declares the table name associated with this class
@EntityListeners({CustomerListner.class})//call the correct listner event methd on lifecylce event
public class Customers {
    
    int cusno; 
    String name;            // This is the only thing that is typed. the rest are generated 
    double credit;
    Orders orders;
    
   Category currentCategory;
    @ManyToOne //one Employee is associated with one of the many s
    @JoinColumn(name="fk_category_number") // the forgien key column to sotre the associate deptno
    public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	
	Set<Products> productsAssigned = new HashSet<>();
	
	
	@ManyToMany (cascade=CascadeType.ALL)// configure many to many assoicationn for entities
	@JoinTable(name="JPA_PRODUCTS_ASSIGMENTS",
				joinColumns= {@JoinColumn(name="fk_cusno")},
				inverseJoinColumns = {@JoinColumn(name="fk_productId")}
				)
	
	public Set<Products> getProductsAssigned() {
		return productsAssigned;
	}

	public void setProductsAssigned(Set<Products> productsAssigned) {
		this.productsAssigned = productsAssigned;
	}

	public Customers() {
        
    }
    
    @Id // marking the property as primary key for the table 
    @Column(name = "customer_number")//using column to provide the default column name
    @GeneratedValue(strategy=GenerationType.AUTO)//AUTO numbering configuration as per DB
    public int getCusno() {
        return cusno;
    }

 

    public void setCusno(int cusno) {
        this.cusno = cusno;
    }
    @Column(name="customer_name", length=50,nullable=false)
    public String getName() {
        return name;
    }

 

    public void setName(String name) {
        this.name = name;
    }

 

    public double getCredit() {
        return credit;
    }

 

    public void setCredit(double credit) {
        this.credit = credit;
    }
    @Enumerated(EnumType.STRING)
    public Orders getOrders() {
        return orders;
    }

 

    public void setOrders(Orders Orders) {
        this.orders = Orders;
    }

 

    @Override
    public String toString() {
        return "Custmer [cusno=" + cusno + ", name=" + name + ", order=" + orders + ", orders=" + orders
                + "]";
    }

 

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customers other = (Customers) obj;
        if (cusno != other.cusno)
            return false;
        return true;
    }
    
    

 

}

 

// @Transient: to mark the property get method, not to be stored in DB table 