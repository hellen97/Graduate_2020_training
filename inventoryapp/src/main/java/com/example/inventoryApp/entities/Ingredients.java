package com.example.inventoryApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JPA_Ingredients")
public class Ingredients {
	
	int ingredno;
	String ingredients;
	String allergyadvice;
	

	public Ingredients() {
		
	}

	@Id
	@Column (name= "Ingredients_number")
	@GeneratedValue(strategy= GenerationType.AUTO)
	public int getIngredno() {
		return ingredno;
	}


	public void setIngredno(int ingredno) {
		this.ingredno = ingredno;
	}

	@Column(name="ingredients", length=100,nullable=false)
	public String getIngredients() {
		return ingredients;
	}


	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Column(name="allergy_advice", length=100,nullable=false)
	public String getAllergyadvice() {
		return allergyadvice;
	}


	public void setAllergyadvice(String allergyadvice) {
		this.allergyadvice = allergyadvice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ingredno;
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
		Ingredients other = (Ingredients) obj;
		if (ingredno != other.ingredno)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Ingredients [ingredno=" + ingredno + ", ingredients=" + ingredients + ", allergyadvice=" + allergyadvice
				+ "]";
	}
	
	

}
