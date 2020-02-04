package com.mastek.training.pack2;

import com.mastek.training.pack1.SimpleClass;

public class DerivedClass extends SimpleClass {

public void main (String[] args) {
		
		DerivedClass sc1 = new DerivedClass();
		System.out.println(
				//in the derived class / different package  you can acces everthing other than private and default
		//"private:" + sc1.privateNumber+
		//	"\nDefault:"+sc1.defaultnumber+
			"\nprotected:"+sc1.protectedNumber+
			"\npublc:"+sc1.publicNumber);
	}
	
}
