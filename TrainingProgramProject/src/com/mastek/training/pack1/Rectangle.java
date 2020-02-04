package com.mastek.training.pack1;

//a class can inherit from interface implements as key woard
// one class can imolement more than one interface 
// interface uses the class object for implementing its behaviours 
// used frequently as it saves additional number of objecrs created 
public class Rectangle implements Shape {
	
	private int length ;
	private int breadth ;
	
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 2* (getLength()+getBreadth());
	} 
	@Override
	public double getPerimeter() {
		return 2* (getLength()+getBreadth());
	}

}
