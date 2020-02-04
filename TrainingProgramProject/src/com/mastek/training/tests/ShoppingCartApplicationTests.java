package com.mastek.training.tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.myshop.Item;
import com.mastek.training.myshop.ListShoppingCart;
import com.mastek.training.myshop.MapShoppingCart;
import com.mastek.training.myshop.SetShoppingCart;
import com.mastek.training.myshop.ShoppingCart;

class ShoppingCartApplicationTests {
	ShoppingCart<Item> sc;

	@BeforeEach
	void setUp() throws Exception {
		//sc = new ListShoppingCart() ; // list example
		//sc = new SetShoppingCart(); // set Example 
		sc = new MapShoppingCart(); // map example 
	}

	@AfterEach
	void tearDown() throws Exception {
		sc = null;
	}

	@Test
	void testShoppingCartAddItem() {
	int size = sc.addItem(new Item (1,"NAME",233.0, 1));
	assertEquals(1,size,"Item added");
	
	}
	
	@Test
	void testShoppingCartPrintaAddItems() {
		//ShoppingCart<Item> sc = new ListShoppingCart();
		sc.addItem(new Item (9,"NAME",233.0, 1));
		sc.addItem(new Item (7,"item",2313.0, 1));
		sc.addItem(new Item (2,"Toy",23223.0, 1));
		sc.addItem(new Item (2, "word", 2111.1,2));
		
		sc.printItems();
		
	
		
	}
	
	@Test
	void testShoppingCartPrintRemoveItems() {
		//ShoppingCart<Item> sc = new ListShoppingCart();
		sc.addItem(new Item (3,"NAME",233.0, 1));
		sc.addItem(new Item (9,"item",2313.0, 1));
		sc.addItem(new Item (6,"Toy",23223.0, 1));
		sc.addItem(new Item (2, "word", 2111.1,2));
		
		int size = sc.removeItem(new Item(2,"name",233.0,1));
		sc.printItems();
		assertEquals(2,size, "item removed" );
		
		
	
	}

}
