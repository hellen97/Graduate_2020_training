package com.example.inventoryApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@Entity
@Table(name="JPA_Customers")
public class Customers {
	
	int custno;
	String custname;
	
	
	public Customers() {
		
	}
	
	Orders currentOrder;
	
	
	@ManyToOne
	@JoinColumn (name="fk_orderno")
	public Orders getCurrentOrder() {
		return currentOrder;
	}

	
//	Set<Products> productsAssigned = new HashSet<>();
//	
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="JPA_PRODUCTS_ASSIGNMENT",
//				joinColumns= {@JoinColumn(name="fk_custno")},
//				inverseJoinColumns= {@JoinColumn(name="fk_prodno")})
//	public Set<Products> getproductsAssigned(){
//		return productsAssigned;
//	}
//
//
//	public void setProductsAssigned(Set<Products> productsAssigned) {
//		this.productsAssigned = productsAssigned;
//	}

	public void setCurrentOrder(Orders currentOrder) {
		this.currentOrder = currentOrder;
	}

	@Id
	@Column (name= "customer_number")
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}
	@Column(name="name", length=50,nullable=false)
	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}


	@Override
	public String toString() {
		return "Customers [custno=" + custno + ", custname=" + custname + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + custno;
		return result;
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
		if (custno != other.custno)
			return false;
		return true;
	}
	

}
