package com.example.inventoryApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="JPA_Orders")
public class Orders {
	
	int orderno;
	int noofitems;
	String orderplaced;
	double total;
	
	public Orders() {
		
		
	}
	
	
	Set<Customers> customerOrders = new HashSet<>();
	
	@OneToMany(mappedBy="currentOrder", cascade=CascadeType.ALL)
	public Set<Customers> getCustomerOrders() {
		return customerOrders;
	}
	public void setCustomerOrders(Set<Customers> customerOrders) {
		this.customerOrders = customerOrders;
	}
	
	Set<Products> productsAssigned = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="JPA_PRODUCTS_ASSIGNMENT",
				joinColumns= {@JoinColumn(name="fk_orderno")},
				inverseJoinColumns= {@JoinColumn(name="fk_prodno")})
	public Set<Products> getproductsAssigned(){
		return productsAssigned;
	}


	public void setProductsAssigned(Set<Products> productsAssigned) {
		this.productsAssigned = productsAssigned;
	}

	
	
	
	
	
	
	@Override
	public String toString() {
		return "Orders [orderno=" + orderno + ", noofitems=" + noofitems + ", orderplaced=" + orderplaced + ", total="
				+ total + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderno;
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
		Orders other = (Orders) obj;
		if (orderno != other.orderno)
			return false;
		return true;
	}
	
	@Id
	@Column (name= "order_number")
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	@Column (name= "number_of_items")
	public int getNoofitems() {
		return noofitems;
	}
	public void setNoofitems(int noofitems) {
		this.noofitems = noofitems;
	}
	@Column (name= "date_of_order")
	public String getOrderplaced() {
		return orderplaced;
	}
	public void setOrderplaced(String orderplaced) {
		this.orderplaced = orderplaced;
	}
	@Column (name= "total")
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	

}
