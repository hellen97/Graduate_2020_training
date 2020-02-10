package com.mastek.inventoryapp.entities;

 

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 

@Entity
@Table(name="JPA_Category")
public class Category {

 

    int    catno;
    String name;
    String type;
    
    Set<Customers> team = new HashSet();
    
    //associates the many enitiys using collecion withcascade enabled 
    @OneToMany(mappedBy="currentCategory", cascade=CascadeType.ALL)
    public Set<Customers> getTeam() {
		return team;
	}



	public void setTeam(Set<Customers> team) {
		this.team = team;
	}



	public Category() {
        
    }

 

    @Id
    @Column(name="Category_number")
    @GeneratedValue (strategy=GenerationType.AUTO)
    public int getCateno() {
        return catno;
    }
    public void setDeptno(int cateno) {
        this.catno = cateno;
    }
    @Column(name="Category_name",length=50,nullable=false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="type_name",length=50, nullable=false)
    public String getType() {
        return type;
    }
    public void setLocation(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Category [cateno=" + catno + ", name=" + name + ", type=" + type + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + catno;
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
        if (catno != other.catno)
            return false;
        return true;
    } 
       
}
