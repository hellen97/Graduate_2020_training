package com.mastek.inventoryapp;

 

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.inventoryapp.dao.CategoryJPADAO;
//import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.inventoryapp.dao.CustomersJPADAO;
import com.mastek.inventoryapp.dao.ProductsJPADAO;
import com.mastek.inventoryapp.entities.Category;
import com.mastek.inventoryapp.entities.Customers;
import com.mastek.inventoryapp.entities.Orders;
import com.mastek.inventoryapp.entities.Products;
//import com.mastek.hrapp.dao.ProjectJPADAO;
//import com.mastek.hrapp.entities.Department;
import com.mastek.inventoryapp.services.CustomersService;

 

@SpringBootTest
class Inventroyapp{
    
    @Autowired // spring will provide the object using IOC, dependency Injection technique
    CustomersService cusSvc;
    
    @Autowired
    CustomersService cusSvc1;
    
    
    
    
    @Autowired
   CustomersJPADAO cusDAO;
    
    @Autowired
    CategoryJPADAO catDAO;
    
    @Autowired
    ProductsJPADAO proDAO;
    
    
    
    @Test
    void testeEmployeeServiceExampleMethod() {
        cusSvc.exampleMethod();
        cusSvc1.exampleMethod();
        
    }
    
    @Test
    void testCustomerDAOAdd() {
        Customers cus = new Customers();
        cus.setName("JIM");
        cus.setCredit(12);
        cus.setOrders(Orders.COLLECT);
        
        cus = cusDAO.save(cus);
        
    
        System.out.println(cus);
        assertNotNull(cus, "Customer Not Added");
    }
    
    @Test
    void testListCustomers() {
        Iterable<Customers> cuss = cusDAO.findAll();
        assertNotNull(cuss,"Customer not Found");
        for (Customers customers : cuss) {
            System.out.println(customers);
        }
    }
    
    @Test
    void testUpdateCustomers() {
    	Customers cus = cusDAO.findById(1).get();
    			System.out.println("Customers fetched:" +cus);
    			
    			cus.setCredit(cus.getCredit()+11);
    			cus.setOrders(Orders.PRENUIUM);
    			cus = cusDAO.save(cus);
    			
    			System.out.println("updated Customers:"+ cus);
    	
  }
    
/*    @Test
    void testDeleteEmployeeById(){
    	// empDAO.delete(emp); deletes by object 
    	
    	empDAO.deleteById(7); // deletes by ID
    }*/
    
    
    
   @Test
   void testCategoryDAOadd() {
      Category cat = new Category();
      cat.setName("New category");
      cat.setLocation("Leeds");
       
       cat = catDAO.save(cat);
       
        System.out.println(cat);
        assertNotNull(cat,"Category Not Added");
    }
    
    @Test
    void testProjectDAOadd() {
        Products pro = new Products();
        pro.setName("New Product");
        pro.setemployeeName("Morrisons");
        
        pro = proDAO.save(pro);
      
        System.out.println(pro);
        assertNotNull(pro,"Project Not Added");
    }

    
    
    @Test
    void testAssignEmployeeToDepartment() {
    	
    	Employee emp = empSvc.assignEmployeeToDepartment(6,8);
    	assertNotNull(emp.getCurrentDepartment(),"Department not assigned");
    	
    
    
    }
    @Test
    void testAssignEmployeeToProject() { 
    	Employee emp = empSvc.assignEmployeeToProject(9,14);
    	assertTrue(emp.getProjectsAssigned().size()>0,"projects assgined");
    }
    
    }

