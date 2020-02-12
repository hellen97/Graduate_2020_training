package com.mastek.Accounts.entities;

 

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
@Table(name="JPA_Accounts")
public class Accounts {

 

    int    accno;
    String name;
    String type;
    
    Set<Customers> team = new HashSet();
    
    //associates the many enitiys using collecion withcascade enabled 
    @OneToMany(mappedBy="currentAccount", cascade=CascadeType.ALL)
    public Set<Customers> getTeam() {
		return team;
	}



	public void setTeam(Set<Customers> team) {
		this.team = team;
	}



	public Accounts() {
        
    }

 

    @Id
    @Column(name="Account_number")
    @GeneratedValue (strategy=GenerationType.AUTO)
    public int getAcctno() {
        return accno;
    }
    public void setAcctno(int acctno) {
        this.accno = acctno;
    }
    @Column(name="Account_name",length=50,nullable=false)
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
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Accounts [acctno=" + accno + ", name=" + name + ", type=" + type + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + accno;
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
        Accounts other = (Accounts) obj;
        if (accno != other.accno)
            return false;
        return true;
    } 
       
}