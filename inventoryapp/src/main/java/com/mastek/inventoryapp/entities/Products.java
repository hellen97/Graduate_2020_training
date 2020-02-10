package com.mastek.inventoryapp.entities;

 

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
@Table(name="JPA_Projects")
public class Products {
    
        int proId;
        String name;
        String customerName;
        
        Set<Customers> productItem = new HashSet<>();
        
    @ManyToMany (mappedBy="projectsAssigned")//provide the property is employee with manytomany and jointable confif
    public Set<Customers> getProjectTeam() {
			return productItem;
		}

		public void setProductItem(Set<Customers> productItem) {
			this.productItem = productItem;
		}

	public Products() {
        
    }
        
        @Id
        @Column(name= "product_number")
        @GeneratedValue(strategy=GenerationType.AUTO)
        public int getProductId() {
            return proId;
        }
        public void setProductId(int productId) {
            this.proId = productId;
        }
        @Column(name="name", length=50,nullable=false)
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Column (name="customer_name", length=50, nullable=false)
        public String getcustomersName() {
            return customerName;
        }
        public void setcustomerName(String customerName) {
            this.customerName = customerName;
        }
        @Override
        public String toString() {
            return "Project [projectId=" + proId + ", name=" + name + ", customerName=" + customerName + "]";
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + proId;
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
            if (proId != other.proId)
                return false;
            return true;
        }

}
        
       