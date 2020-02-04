package com.mastek.training.tests;

import com.mastek.training.compositionbook.Author;
import com.mastek.training.compositionbook.Book;

/* 
 * A test case for book class 
 */

public class TestBook {
 public static void main(String[] args) {
	  
 // Creating an Author instance to create a instance of Book
	 Author benHadlow = new Author( "Benjamin", "training@mastek.com",'m');
	 System.out.println(benHadlow); // Authors toString()
	 
	 //Test Books constructor and toString()
	 Book testBook = new Book ("Java for dummies", benHadlow, 9.99, 99);
	 System.out.println(benHadlow);
	 // books toString() 
	 
	 
	 //  Test setters and getters 
	 testBook.setPrice(9.88);
	 testBook.setQty(88);
	 System.out.println(testBook); // books toString 
	 System.out.println("name is:" + testBook.getName());
	 System.out.println("prie is :"+ testBook.getPrice()); 
	 System.out.println("qty is:" + testBook.getQty());
	 System.out.println("Authors name is "+ testBook.getAuthor().getName());
	 System.out.println("Authors email is "+ testBook.getAuthor().getEmail());
	 System.out.println("Authors gender is "+ testBook.getAuthor().getGender());
	 
	 
	 // using an anonymous Author instance to create a book instance 
	 
	 Book testBookInstance = new Book (" java for more dummies", new Author("Brian lee", "brian@nowhere.com", 'm'),19.99, 8); 
	 
	//System.out.println()
	 
	 
	 
 }
}
