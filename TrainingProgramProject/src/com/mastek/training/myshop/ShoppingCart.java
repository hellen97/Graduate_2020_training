package com.mastek.training.myshop;

public interface ShoppingCart<I> {
// allways list the list you will need on interface 
// type<I> WOULD BE DIFINED AT UASGE TIME WITH TYPE OF CLASS 
	
	public int addItem(I i);
	public int removeItem(I i);
	public void printItems();
	public double getTotalPrice(double taxPercentage, double discountPercentage);
	

	
}
