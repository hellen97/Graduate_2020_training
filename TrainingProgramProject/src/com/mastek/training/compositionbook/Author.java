package com.mastek.training.compositionbook;
//The author class 
public class Author {
// private instance variables 
	private String name;
	private String email;
	private String gender; // char allowing for "M" or "F" to be recived 
	
	// CONSTRUCTOR
	public Author (String name , String email, String  string) {
		this.name = name;
		this.email = email;
		this.gender =  string;
	}
	
	//GETTERS / SETTERS 
	// Public getters and setters for the private instance variables 
	
	public Author(String name2, String email2, char c) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setEmail(String email) {
		this.email = email; 
	}
	
	public String getEmail() { 
		return email;
	}
	
	public String toString() {
		return name+ " ("+ gender + ") at" +email;
	}
	
}
