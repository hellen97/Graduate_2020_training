package com.mastek.training.pack1;

import java.util.Scanner;

public class ExceptionExample {
	
	public static void main(String[]args) {
	int num1=0,num2=0, result=0;
	
	Scanner sc = new Scanner (System.in); 
	
	try {
		System.out.println("enter num1:");
		num1 = Integer.parseInt(sc.nextLine());  // fetch the string from console anf parse to int 
		
		
		System.out.println("enter num2:");
		num2 = Integer.parseInt(sc.nextLine());
		
		result = num1/num2;
		System.out.println("Divison is:" + result);
		
		
	} catch (NumberFormatException e) {// handle specific scenarios of exceptions. 
		e.printStackTrace(); //print the exception and information on the console 
		System.err.println("Please enter a number");
	}

	catch (Exception ex) {// handles all tpyes of exceptions
		
		System.err.println("Exception occured"+ex); // print the exception with message 
		System.err.println("Exception message"+ex.getMessage()); // print the complete information about exception :: stack trace 
		
	}
	
	finally { // blovk will be executed in all the scenarios of success of fail of an application 	
		// in case the exception is not handled, it will abort the application after the finally block 
		System.out.println("Scanner closed");
		sc.close();
	}
	// represent the rest of the code 
	System.out.println("program completed");
	}
}