package com.mastek.training.basics;

public class ExampleApplication {
	
	public static void main(String[] args) {
		int maxResult =0;
		maxResult = SolutionProvider.getMaxNumber(101, 82);
		System.out.println("Max Result is:"+ maxResult);	
}
	
	
	  public static double smallest(double x, double y, double z)
	    {
	        return Math.min(Math.min(x, y), z);
	    }
	}


