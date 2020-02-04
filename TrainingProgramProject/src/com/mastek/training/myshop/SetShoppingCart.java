package com.mastek.training.myshop;

import java.util.Set;
import java.util.TreeSet;

public class SetShoppingCart implements ShoppingCart<Item> {
	
	Set<Item> items;
	
	public SetShoppingCart() { 
		//using hashset to manage unique items in random order 
		//items = new HashSet<>();// diamond operator with new keyword since JDK 1.7 
		// new HashSet<Item> ();  
		
		items = new TreeSet<> () ; // using tree set to store items in sorted order 
	}

	@Override
	public int addItem(Item i) {
		items.add(i); 
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		items.remove(i);
	
		return items.size();
	}

	@Override
	public void printItems() {
		System.out.println(" items in chart");
		for (Item item : items ) {
			System.out.println(item);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
