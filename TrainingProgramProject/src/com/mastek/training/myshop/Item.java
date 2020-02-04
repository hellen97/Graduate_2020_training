package com.mastek.training.myshop;

public class Item 

implements Comparable<Item> // it provies the default sorting for TreeSet

{
	
	private int itemId;
	private String itemName;
	private int itemQty;
	private double unitPrice;
	
	public Item() {
		
	}
	

	public Item(int Itemid, String itemName, double unitPrice, int itemQty) {
		setItemId(Itemid);
		setItemName(itemName);
		setUnitPrice(unitPrice);
		setItemQty(itemQty);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	}

	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemQty=" + itemQty + ", unitPrice=" + unitPrice
				+ "]";
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	@Override
	public int compareTo(Item anotherItem) {
		// return a number 
		//+ve : current object is greater than anotherItem
		//0: current object is equal to anotherItem
		//-ve : current object is less than anotherItem
		System.out.println("comparing item");
		return this.getItemId()-anotherItem.getItemId();
		// we all need to compare the uniuq key valies for mangaging order
		}



}