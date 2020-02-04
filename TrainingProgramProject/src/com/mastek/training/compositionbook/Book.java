package com.mastek.training.compositionbook;

public class Book {
	
	/*
	 * The Book class models a book with one (and only one) author.
	 */
	
	//Private instace varaibles 
	private String name;
	private Author author;
	private double price; //double as the price may be to a decimal point
	private int qty; 
	
	// declare Constrcutor
	
	public Book (String name, Author author, double price, int qty) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = qty ;
	}
	
	
	// Set Getters and Setters !
	
	public String getName() {
		return name ;
		
	}
	
	public double getPrice() {
		return price ;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
	this.qty=qty;
	}
	
	public void setPrice(double price) {
		this.price = price; 
		
	}
	
	public Author getAuthor() {
		return author; // return the member author, which is an instance of the class Author 
	}
	
	public String toString() {
		return "'"+ name +"' by" + author; // 
	}
	
}




