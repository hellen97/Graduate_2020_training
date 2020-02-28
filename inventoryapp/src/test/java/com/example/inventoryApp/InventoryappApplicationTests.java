package com.example.inventoryApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.inventoryApp.dao.CategoryJPADAO;
import com.example.inventoryApp.dao.CustomersJPADAO;
import com.example.inventoryApp.dao.IngredientsJPADAO;
import com.example.inventoryApp.dao.OrdersJPADAO;
import com.example.inventoryApp.dao.ProductsJPADAO;
import com.example.inventoryApp.entities.Category;
import com.example.inventoryApp.entities.Customers;
import com.example.inventoryApp.entities.Ingredients;
import com.example.inventoryApp.entities.Orders;
import com.example.inventoryApp.entities.Products;
import com.example.inventoryApp.services.CategoryServices;
import com.example.inventoryApp.services.CustomersServices;
import com.example.inventoryApp.services.IngredientsServices;
import com.example.inventoryApp.services.OrdersServices;
import com.example.inventoryApp.services.ProductsServices;


@SpringBootTest
class InventoryAppApplicationTests {
	@Autowired
	CustomersServices cusSvc;
	
	@Autowired
	CustomersJPADAO cusdao;
	
	@Autowired
	OrdersServices ordSvc;
	
	@Autowired
	OrdersJPADAO orddao;
	
	@Autowired
	ProductsServices prodSvc;
	
	@Autowired
	ProductsJPADAO proddao;
	
	@Autowired
	IngredientsServices ingrSvc;
	
	@Autowired
	IngredientsJPADAO ingrdao;
	
	@Autowired
	CategoryServices catSvc;
	
	@Autowired
	CategoryJPADAO catdao;
	
	@Test
	void categoryDAOadd() {
	Category cat = new Category();
	cat.setCategorgytype("Dairy");
	
	cat = catdao.save(cat);
	assertNotNull(cat, "Category Not Added");
	}


	@Test
	void customerDAOadd() {
	Customers cus= new Customers();
	cus.setCustname("chow");
	
	cus = cusdao.save(cus);
	assertNotNull(cus, "Customer Not Added");
	
	}
	
	@Test
	void orderDAOadd() {
	Orders ord = new Orders();
	ord.setNoofitems(3);
	ord.setOrderplaced("01/02/2020");
	ord.setTotal(45.00);
	
	ord = orddao.save(ord);
	assertNotNull(ord,"Order Not Added");
		
	}

	@Test
	void productDAOadd() {
	Products prod = new Products();
	prod.setProdtype("Snacks");
	prod.setProddes("Biscuits");
	prod.setPrice(2.00);
	
	prod = proddao.save(prod);
	assertNotNull(prod, "Product Not Added");
	} 
	
	@Test
	void IngredientDAOadd() {
	Ingredients ingr = new Ingredients();
	ingr.setIngredients("Wheat Flour,Butter, Yeast, Sugar, Water");
	ingr.setAllergyadvice("Contains: Wheat, Milk, Egg");
	
	ingr = ingrdao.save(ingr);
	assertNotNull(ingr, "Ingredients Not Added");
	
	}
	
	
	/*@Test
	void testAssignCustomersToOrders() {
				// empSVC. assigning employee to department (empno, deptno)
	Customers  cus = cusSvc.assignCustomersToOrders(122, 125);
	assertNotNull(cus.getCurrentOrder(),"order Not Assigned");
	}*/
	
/*	@Test
	void testAssignOrdersToProducts() {
		Orders ord = ordSvc.assignOrderToProduct(125, 132);
		assertTrue(ord.getproductsAssigned().size()>0, "project assigned");
	}*/
}
