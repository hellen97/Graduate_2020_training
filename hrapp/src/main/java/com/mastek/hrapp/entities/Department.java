package com.mastek.hrapp.entities;

 

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
import javax.ws.rs.FormParam;

 

@Entity
@Table(name="JPA_Deparments")
public class Department {

 

    int depno;
    @FormParam ("name")
    String name;
    @FormParam ("location")
    String location;
    
    Set<Employee> team = new HashSet<Employee>();
    
    //associates the many enitiys using collecion withcascade enabled 
    @OneToMany(mappedBy="currentDepartment", cascade=CascadeType.ALL)
    public Set<Employee> getTeam() {
		return team;
	}



	public void setTeam(Set<Employee> team) {
		this.team = team;
	}



	public Department() {
        
    }

 

    @Id
    @Column(name="department_number")
    @GeneratedValue (strategy=GenerationType.AUTO)
    public int getDeptno() {
        return depno;
    }
    public void setDeptno(int deptno) {
        this.depno = deptno;
    }
    @Column(name="department_name",length=50,nullable=false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="location_name",length=50, nullable=false)
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "Department [deptno=" + depno + ", name=" + name + ", location=" + location + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + depno;
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
        Department other = (Department) obj;
        if (depno != other.depno)
            return false;
        return true;
    } 
       
}
 