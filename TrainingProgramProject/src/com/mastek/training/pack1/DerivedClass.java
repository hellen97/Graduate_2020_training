package com.mastek.training.pack1;

public class DerivedClass extends SimpleClass {

public void main (String[] args) {
		
		DerivedClass sc1 = new DerivedClass();
		System.out.println(
				//in the derived class you can acces everthing other than private 
		//"private:" + sc1.privateNumber+
			"\nDefault:"+sc1.defaultnumber+
			"\nprotected:"+sc1.protectedNumber+
			"\npublc:"+sc1.publicNumber);
	}
	
}
