package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
// A test case for the author class

import com.mastek.training.compositionbook.Author;


public class TestAuthor { 
		public static void main (String[]args) {
		// Test constructor and toString() 
		Author benHadlow = new Author ("benHadlow", "training@mastek.com", "M" );
		System.out.println(benHadlow); // toString(()
		
		
		//Test Setters and Getters
		benHadlow.setEmail("training@mastek.com");
		// print our results 
		System.out.println(benHadlow); // toString() 
		System.out.println("name is" + benHadlow.getName());
		System.out.println("Gender is" +benHadlow.getGender());
		System.out.println("email is" + benHadlow.getEmail());
			
		}
		
}
