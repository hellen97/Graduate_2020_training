package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.dao.DataAccessObject;
import com.mastek.training.hrapp.dao.EmployeeJDBCDAO;
import com.mastek.training.hrapp.dao.EmployeeJSONfileDAO;
import com.mastek.training.hrapp.dao.EmployeeMongoDAO;

class EmployeeDAOTests {
	
	 DataAccessObject<Employee> empDAO;
	

	@BeforeEach
	void setUp() throws Exception {
		//empDAO = new EmployeeBinaryFileDAO("empdata.dat");
		//empDAO = new EmployeeJSONfileDAO("Example.json");
		//empDAO = new EmployeeJDBCDAO();
		  empDAO = new EmployeeMongoDAO();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddEmployeeData() {
	Employee newEmp = new Employee();
	newEmp.setEmpno(1111);
	newEmp.setName("Example");
	newEmp.setDesignation(Designations.DEVELOPER);
	newEmp.setGrade(Grades.G4);
	newEmp.setUnitDaySalary(233);
	
	newEmp = empDAO.add(newEmp); // returns the object if saved successfully 
	assertNotNull( newEmp, "Employee added");
	
	/*String jsonOBJ = Employee.getJSONString(newEmp);
	System.out.println(jsonOBJ);
	Employee examp = Employee.parseJSONString(jsonOBJ);
	System.out.println(examp);
*/	
	
	Employee fetchEmp = empDAO.find(1111);
	assertNotNull(fetchEmp,"Employee not added");
	
	}
	
	@Test
	void testListAllEmployee() {
		Collection<Employee> emps = empDAO.listAll();
		for (Employee employee: emps) {
			System.out.println(employee);
		}
		
	}
 
	@Test 
	void testRemoveEmployee(){
		Employee newEmp = new Employee();
		newEmp.setEmpno(12);
		newEmp.setName("example");
		newEmp.setDesignation(Designations.DEVELOPER);
		newEmp.setGrade(Grades.G8);
		newEmp.setUnitDaySalary(233);
		
		newEmp = empDAO.add(newEmp);
		assertNotNull(newEmp,"Employee not added");
		
		Employee removedEmp = empDAO.remove(1111);
		assertNotNull(removedEmp,"Employee removed");
		 
		Employee checkremovedEmp = empDAO.find(1111);
		assertNull(checkremovedEmp,"Employee added");
	
	}
}
