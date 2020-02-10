package com.mastek.inventoryapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component // class is initalized by Spring Application Context 
public class CustomerListner {
	
	
	//@life-cycle <event>
	// @<Event>
	// public void <method-name>(Entity e)

		

		@PrePersist // calls this method before inserting each emp object in employee table
		public void beforeEmpInsert(Customers c) {
		System.out.println("Before customer Insert: "+c);
		System.out.println("raised email request for"+c.getName());

		}



		@PostPersist // calls this method after inserting each emp object in the employee table 
		public void afterEmpInsert(Customers c) {

			System.out.println("After Insert: "+c);
			System.out.println("Screen Name Generated:"+c.getName()+c.getCusno());

		}

		

		@PreUpdate // calls the method before updating each emp object in employee table
		public void beforeUpdate(Customers c) {

			System.out.println("Before Update: "+c);

		}



		@PostUpdate // calls this method after updating each emp object in employee table
		public void afterUpdate(Customers c) {

			System.out.println("After Update: "+c);

		}
		
		@PostLoad
		public void afterLoading (Customers c ) {
			System.out.println("Customer Number fetched:"+c);
		}
		

		@PreRemove
		public void beforeDelete(Customers c) {

			System.out.println("Print Before Delete: "+c);

		}



		

	}


