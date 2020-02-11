package com.mastek.hrapp;

 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmentJPADAO;
//import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPostionsDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.CheckPayment;
import com.mastek.hrapp.entities.Department;
//import com.mastek.hrapp.dao.ProjectJPADAO;
//import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPostion;
import com.mastek.hrapp.entities.Payment;
import com.mastek.hrapp.entities.Project;
//import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

 

@SpringBootTest
class HrappApplicationTests {
    
    @Autowired // spring will provide the object using IOC, dependency Injection technique
    EmployeeService empSvc;
    
    @Autowired
    EmployeeService empSvc1;
    
    @Autowired
    PaymentJPADAO paymentDAO;
    
    
    @Autowired
    EmployeeJPADAO empDAO;
    
    @Autowired
    DepartmentJPADAO depDAO;
    
    @Autowired
    ProjectJPADAO proDAO;
    
    @Autowired
    JobPostionsDAO jobDAO;
    
    @Test
    void testAddJobPostionDocument() {
    	JobPostion jp = new JobPostion();
    	jp.setJobId(122);
    	jp.setLocation("Leeds");
    	jp.setSkillesRequierd("NHS");
    	jp.setNoOfPostions(3);
    	
    	jobDAO.save(jp);
    	
    	assertNotNull(jp,"Job Positions not saved");
    }
    
    @Test 
    void testListAllJobPostions() {
    System.out.println("print all job postions");
    for(JobPostion jp: jobDAO.findAll()){
    	System.out.println(jp);
    
    }
    
    }
    
    @Test
    void  testFindEmployeesBySalary(){
    	
    	double minSalary=1.0;
    	double maxSalary=1000.0;
    								// empDAO.findBySalary(minSalary, maxSalary)
    	Iterable<Employee> emps = empDAO.findBySalary(1.0,1000.0);
    	System.out.println("All employees having salary between 1.0 and 1000.0 "+minSalary + " and max" +maxSalary);
    	for (Employee employee : emps) {
			System.out.println(employee);
		}
    	
    }
    
    @Test
    void testcashPaymentAdd() {
    	Payment cashP = new Payment();
    	cashP.setAmount(100);
    	
    	cashP= paymentDAO.save(cashP);
    	
    	System.out.println(cashP);
    	assertNotNull(cashP,"Cash Paymet Not saved");
    }
    
    
    @Test
    void testCardPaymentAdd() {
    	CardPayment cardP = new CardPayment();
    		cardP.setAmount(2300);
    		cardP.setCardNumber(1232);
    		cardP.setCardService("visa");
    		
    		cardP = paymentDAO.save(cardP);
    				System.out.println(cardP);
    				assertNotNull(cardP,"Card Payment not saved");
    		
    }
    
    @Test
    void testCheckPaymentAdd() {
    		CheckPayment  checP = new CheckPayment();
    		checP.setAmount(444);
    		checP.setBankName("rbs");
    		checP.setCheckNumber(1223);
    		
    		checP = paymentDAO.save(checP);
    		System.out.println("check payment not saved");
    		
    		
    }
    @Test
    void testeEmployeeServiceExampleMethod() {
        empSvc.exampleMethod();
        empSvc1.exampleMethod();
        
    }
    
    @Test
    void testEmployeeDAOAdd() {
        Employee emp = new Employee();
        emp.setName("JIM");
        emp.setSalary(9997);
        emp.setDesignation(Designation.DEVELOPER);
        
        emp = empDAO.save(emp);
        
    
        System.out.println(emp);
        assertNotNull(emp, "Employee Not Added");
    }
    
    @Test
    void testListEmployees() {
        Iterable<Employee> emps = empDAO.findAll();
        assertNotNull(emps,"Employee not Found");
        for (Employee employee : emps) {
            System.out.println(employee);
        }
    }
    
    @Test
    void testUpdateEmployees() {
    	Employee emp = empDAO.findById(1).get();
    			System.out.println("Employee fetched:" +emp);
    			
    			emp.setSalary(emp.getSalary()+11);
    			emp.setDesignation(Designation.ARCHITECT);
    			emp = empDAO.save(emp);
    			
    			System.out.println("updated employee:"+ emp);
    	
  }
    
/*    @Test
    void testDeleteEmployeeById(){
    	// empDAO.delete(emp); deletes by object 
    	
    	empDAO.deleteById(7); // deletes by ID
    }*/
    
    
    
   @Test
   void testDepartmentDAOadd() {
      Department dep = new Department();
      dep.setName("New Dep");
      dep.setLocation("Leeds");
       
       dep = depDAO.save(dep);
       
        System.out.println(dep);
        assertNotNull(dep,"Department Not Added");
    }
    
    @Test
    void testProjectDAOadd() {
        Project pro = new Project();
        pro.setName("New Project");
        pro.setemployeeName("Morrisons");
        
        pro = proDAO.save(pro);
        
        System.out.println(pro);
        assertNotNull(pro,"Project Not Added");
    }
    
    @Test
    void testFindEmployeeByDesignation() {
    	Iterable<Employee> emps = empDAO.findByDesignation(Designation.TESTER);
    	System.out.println("all emoloyees with designation as "+ Designation.TESTER);
    	
    	for (Employee employee :emps) {
    		System.out.println(employee);
    	}
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
    
    
    @Test
    void testApplyForJobPosition() {
    	JobPostion jp = empSvc.applyForJobPosition(1, 123);    
    	
  assertNotNull (jp, "jOB NOT APPLIED:"+123);
  System.out.println("applicants for JOB ID:");
    
  for (Employee applicant : jp.getApplicants()) {
	  System.out.println(applicant);
  }
    }
    
    }


