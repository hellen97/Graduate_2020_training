package com.mastek.training.pack1;

public class SimpleClass {
	private int privateNumber =10;
	int defaultnumber = 10;
	protected int protectedNumber = 10;
	public int publicNumber=10;

	
	public void main (String[] args) {
		
		SimpleClass sc1 = new SimpleClass();
		System.out.println(
		"private:" + sc1.privateNumber+
			"\nDefault:"+sc1.defaultnumber+
			"\nprotected:"+sc1.protectedNumber+
			"\npublc:"+sc1.publicNumber);
	}
}


