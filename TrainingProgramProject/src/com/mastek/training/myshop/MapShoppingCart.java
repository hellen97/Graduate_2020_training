package com.mastek.training.myshop;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapShoppingCart implements ShoppingCart<Item> {

	
	Map<Integer, Item> items;
	
	public MapShoppingCart() 
	{
		// items = new HashMap<>();
		
		items = new TreeMap<>();// sorts all the entires using the keys (ItemID)  
	}
	
		
	
	@Override
	public int addItem(Item i) {
		items.put(i.getItemId(), i); 		//map.remove(key) 
		return items.size();
	}

	@Override
	public int removeItem(Item i) {  //map.remove(Key)
		items.put(i.getItemId(), i); 
		return items.size();
	}

	@Override
	public void printItems() {
		System.out.println("Items in cart");
		for (Integer itemId: items.keySet()) { // get all the keys from the map 
			Item i = items.get(itemId); // gets the value from the map using the key 
			System.out.println(i);
		}

	}

	@Override
	public double getTotalPrice(double taxPercentage, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
