package com.mastek.training.hrapp;

//Each class specifies their base/parent class name using extends keyword 
// if the class does not have extents keyword it is by default inheriting java.lang.object

public class SalesEmployee extends Employee {
	
	private long target;
	private double commission;
	
	
	public SalesEmployee() {
		//use super keyword to call the base class constructor from the child/derived class
		// super constructor call must be the first line in the constructor 
	super(777,"SalesExample",99,Designations.DEVELOPER);
	System.out.println();
						   }
	
	
	//overriding method 	
	// we write the same method available in base class in child class with different or 
	// additional logic for processing the result.
	//@Override
	//public double getNetSalary(int noOfDays) {
		// TODO Auto-generated method stub
		//return (super.getNetSalary(noOfDays)+(super.getNetSalary(noOfDays)*getCommission()));
				//							}
	

		public long getTarget() {
		return target;
								}
		public void setTarget(long target) {
		this.target = target;
											}
		public double getCommission() {
		return commission;
										}
		public void setCommission(double commission) {
		this.commission = commission;
													}
	

}
