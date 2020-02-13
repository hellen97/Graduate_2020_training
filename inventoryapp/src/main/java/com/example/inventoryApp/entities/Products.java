package com.example.inventoryApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="JPA_Products")
public class Products {

		int prodno;
		String prodtype;
		String proddes;
		double price;
	
	Set<Orders> productOrders = new HashSet<>();
	

		
	@ManyToMany (mappedBy="productsAssigned")
	public Set<Orders> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(Set<Orders> productOrders) {
		this.productOrders = productOrders;
	}



	public Products() {
		
	}
		
	
	
		@Override
		public String toString() {
			return "Products [prodno=" + prodno + ", prodtype=" + prodtype + ", proddes=" + proddes + ", price=" + price
					+ "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + prodno;
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
			Products other = (Products) obj;
			if (prodno != other.prodno)
				return false;
			return true;
		}
		
		@Id
		@Column (name="product_number")
		@GeneratedValue(strategy=GenerationType.AUTO)
		public int getProdno() {
			return prodno;
		}
		public void setProdno(int prodno) {
			this.prodno = prodno;
		}
		@Column(name="product_type", length=50,nullable=false)
		public String getProdtype() {
			return prodtype;
		}
		public void setProdtype(String prodtype) {
			this.prodtype = prodtype;
		}
		
		@Column(name="product_description", length=100)
		public String getProddes() {
			return proddes;
		}
		public void setProddes(String proddes) {
			this.proddes = proddes;
		}
		@Column(name="price", length=50,nullable=false)
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		
}
