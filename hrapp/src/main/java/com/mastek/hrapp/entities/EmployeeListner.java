package com.mastek.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component // class is initalized by Spring Application Context 
public class EmployeeListner {
	
	
	//@life-cycle <event>
	// @<Event>
	// public void <method-name>(Entity e)

		

		@PrePersist // calls this method before inserting each emp object in employee table
		public void beforeEmpInsert(Employee e) {
		System.out.println("Before emp Insert: "+e);
		System.out.println("raised emial request for"+e.getName());

		}



		@PostPersist // calls this method after inserting each emp object in the employee table 
		public void afterEmpInsert(Employee e) {

			System.out.println("After Insert: "+e);
			System.out.println("Screen Name Generated:"+e.getName()+e.getEmpno());

		}

		

		@PreUpdate // calls the method before updating each emp object in employee table
		public void beforeUpdate(Employee e) {

			System.out.println("Before Update: "+e);

		}



		@PostUpdate // calls this method after updating each emp object in employee table
		public void afterUpdate(Employee e) {

			System.out.println("After Update: "+e);

		}
		
		@PostLoad
		public void afterLoading (Employee e ) {
			System.out.println("Employee fetched:"+e);
		}
		

		@PreRemove
		public void beforeDelete(Employee e) {

			System.out.println("Before Delete: "+e);

		}



		

	}


