package com.mastek.training.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Annoucement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailA;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSA;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.pack1.Circle;
import com.mastek.training.pack1.Rectangle;
import com.mastek.training.pack1.Shape;
class HRApplicationTests {
	
	Employee ex1;
	@BeforeEach
	public void setupEmpTestCases() {
		//Employee.DEFAULT_ZERO; //<class_name>.<static_member>;
		System.out.println("Before test case");
		ex1 = new Employee();
		ex1.setEmpno(1002);
		ex1.setName("Example");
		ex1.setUnitDaySalary(300);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8);
		
		@SuppressWarnings("unused")
		Employee ex2 = new Employee(1122);
		@SuppressWarnings("unused")
		Employee ex3 = new Employee(2233,"Examle",344.0,Designations.DEVELOPER);
		
		ex2=null; // realese the object as garbage 
		ex3=null; 
		System.gc();
		
		//ex2.getEmpno(); 
		
		
		
	}
	@AfterEach
	public void tearDownEmpTestCases() {
		System.out.println("after test case");
		
	}
	@Test
	void testCreateAndPrintExampleEmployeeObjext() {
		
		System.out.println(
							"Number:"+ex1.getEmpno()+
							"\nName:"+ex1.getName()+
							"\nDay salary:"+ex1.getUnitDaySalary()+
							"\ndesignation:"+ex1.getDesignation()+
							"\nGrade:"+ex1.getGrade()
							);
			
	}
	
	@Test
	void testcreateandComputeSalaryEmployeeObject() {
		try {
			assertEquals(9000,ex1.getNetSalary(30),"invalid net salary computation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println("Exception occured: "+e);
		}
		try {
			assertEquals(0,ex1.getNetSalary(-30),"invalid net salary computation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Exception occured: "+e);
		}		
	}

	@Test
	void testSalesEmployeeObjectsUsage() {
		SalesEmployee saleEx1 = new SalesEmployee();
		saleEx1.setEmpno(224);
		saleEx1.setName("example name");
		saleEx1.setUnitDaySalary(100);
		saleEx1.setDesignation(Designations.DEVELOPER);
		saleEx1.setGrade(Grades.G8);
		saleEx1.setTarget(10000000);
		saleEx1.setCommission(0.8);
		
		
	//	assertEquals(1620,saleEx1.getNetSalary(9),"invalid salary");
	

}
	
	@Test
	void testObjectFeaturesOnEmployee() {
	System.out.println("<===object features   START===>");
	
	System.out.println(ex1.toString());
	System.out.println("Hashcode:"+ex1.hashCode());
	
	System.out.println("<===object features  END===>");
	}
	@Test
	void testSendAnoucementToEmployees() {
		
		// we cannot create an object of abstract class using new as keywaord
		// annoucment exAnnoucement();
		
		// to use an abstract class the oject you use must extend it with th derived class
		// and overide ALL abstract methos define in the base / parent class 
		Annoucement exSMS = new SMSA();
		exSMS.setFrom("UK/ INDIA");
		exSMS.setForGroup("Mastek_glasgow");
		exSMS.setSubject("boring subject");
		exSMS.setContentText("All work from home");
		
		
		Annoucement exEmail = new EmailA();
		exSMS.setFrom("UK/ INDIA");
		exSMS.setForGroup("Mastek_glasgow");
		exSMS.setSubject("boring subject");
		exSMS.setContentText("All work from home");
		
		if (exSMS instanceof SMSA) {
			System.out.println("connect the telecom sms service");
			exSMS.sendA(); 
		}
		

		if (exEmail instanceof EmailA) {
			System.out.println("connect the telecom EMAIL service");
			exSMS.sendA();
		}
		exSMS.sendA();  // sends the sms message
		exEmail.sendA(); // sends the email message 
		
		assertTrue(exSMS instanceof SMSA, " invalid Announcemnt implementation");

		assertTrue(exSMS instanceof EmailA, " invalid Announcemnt implementation");
		
		
		

		
		
	}
		
	
	
	@Test
	void testShapeExample() {
		
		Rectangle rect = new Rectangle() ;
		rect.setLength(10);
		rect.setBreadth(20);
		
		Circle circle = new Circle();
		circle.setRadius(20);
		
		Shape shReat = rect;
		Shape shCircle = circle;
		
		System.out.println (" Area"+shReat.getArea());
		System.out.println (" Area"+shReat.getPerimeter());
		
		System.out.println("Cirle"+shCircle.getArea());
		System.out.println (" cirle"+shCircle.getPerimeter());
		
		
		assertTrue(rect instanceof Shape, " Invlaid Type of Shape");
		assertTrue(circle instanceof Shape, " Invlaid Type of Shape");
		
		
		
	}
		
	}

