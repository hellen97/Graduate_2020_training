package com.example.inventoryApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="JPA_Category")
public class Category {

		int categoryno;
		String categorgytype;
		
public Category() {
	
}
		
		
		@Id
		@Column (name= "category_nuumber")
		@GeneratedValue(strategy= GenerationType.AUTO)
		public int getCategoryno() {
			return categoryno;
		}
		public void setCategoryno(int categoryno) {
			this.categoryno = categoryno;
		}
		@Column(name="category_type", length=50,nullable=false)
		public String getCategorgytype() {
			return categorgytype;
		}
		public void setCategorgytype(String categorgytype) {
			this.categorgytype = categorgytype;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + categoryno;
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
			Category other = (Category) obj;
			if (categoryno != other.categoryno)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Category [categoryno=" + categoryno + ", categorgytype=" + categorgytype + "]";
		}
		
		
		
}
