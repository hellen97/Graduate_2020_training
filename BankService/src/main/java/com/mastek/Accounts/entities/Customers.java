package com.mastek.Accounts.entities;

 

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient; 



@Entity // declares the class as entity, to be managed by JPA
@Table(name="JPA_Customers") // declares the table name associated with this class
@EntityListeners({CustomersListner.class})//call the correct listner event methd on lifecylce event
@NamedQueries({
@NamedQuery(name="Customers.findById", // delcare the query name as the method in DAO
query="select c from Customers c where c.id between :minId and :maxId"),
// identify thr query to fetch customers objects with properties and paramters 
// all the params are to be declared using @Param("<name>") in the DAO interface 


@NamedQuery(name="Customers.findByCustomerType",
				query="select c from Customers c where c.CustomerType=:customertype")	
})
public class Customers {
    
    int custno; 
    String name;            // This is the only thing that is typed. the rest are generated 
    int id;
    CustomerType customertype;
    
    Accounts currentAccounts;
    @ManyToOne //one Employee is associated with one of the many departments
    @JoinColumn(name="fk_department_number") // the forgien key column to sotre the associate deptno
    @Transient // ignore this prooeprty when storing employee data in MongoDB
    public Accounts getCurrentAccounts() {
		return currentAccounts;
	}

	public void setCurrentAccounts(Accounts currentAccounts) {
		this.currentAccounts = currentAccounts;
	}

	
	Set<Transaction> transactionAssigned = new HashSet<>();
	
	
	@ManyToMany (cascade=CascadeType.ALL)// configure many to many assoicationn for entities
	@JoinTable(name="JPA_TRANSACTION",
				joinColumns= {@JoinColumn(name="fk_empno")},
				inverseJoinColumns = {@JoinColumn(name="fk_projectId")}
				)
	
	
	@Transient // ignore this prooeprty when storing employee data in MongoDB
	public Set<Project> getProjectsAssigned() {
		return projectsAssigned;
	}

	public void setProjectsAssigned(Set<Project> projectsAssigned) {
		this.projectsAssigned = projectsAssigned;
	}

	public Employee() {
        
    }
    
    @Id // marking the property as primary key for the table 
    @Column(name = "employee_number")//using column to provide the default column name
    @GeneratedValue(strategy=GenerationType.AUTO)//AUTO numbering configuration as per DB
    public int getEmpno() {
        return empno;
    }

 

    public void setEmpno(int empno) {
        this.empno = empno;
    }
    @Column(name="employee_name", length=50,nullable=false)
    public String getName() {
        return name;
    }

 

    public void setName(String name) {
        this.name = name;
    }

 

    public double getSalary() {
        return salary;
    }

 

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Enumerated(EnumType.STRING)
    public Designation getDesignation() {
        return designation;
    }

 

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

 

    @Override
    public String toString() {
        return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", designation=" + designation
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
        Employee other = (Employee) obj;
        if (empno != other.empno)
            return false;
        return true;
    }
    
    

 

}

 

// @Transient: to mark the property get method, not to be stored in DB table 