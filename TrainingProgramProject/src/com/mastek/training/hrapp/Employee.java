//location of the java class in the project structure 
package com.mastek.training.hrapp;

import java.io.Serializable;
import java.io.StringReader;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

import org.bson.Document;

//if the class is declared as final, we cannot subclass/ inherit/ extends the class
public class Employee implements Serializable{
									//Serializable as marker interface to manage serialization
									// using ObjectOutStream/InputStream classes 
	
	private int empno;
	private String name;
	private double unitDaySalary;
	private static Designations designation;
	private transient Grades grade; // transient keyword will denote the serializer to skip this
									// field while storing using binary file. 
	
	public static final int MAX_PAID_DAYS=90;
	public static final int MIN_DAY_RATE=10;
	public static final int MAX_DAY_RATE=999999;
	public static final int DEFAULT_ZERO=0;
	public static final int MAX_EMPNO=99999;
	
	//blocks
	//static block: executed at class loading time for each class - once 
	//
	
	static {   //we usr static block to initialise all the static members of the class 
			System.out.println("Employee static block called");
	}
	
	
	//instance block: executed before the constructor is called for any object of the class 
	
	{
		setEmpno(9999);
		setName("example");
		setUnitDaySalary(MIN_DAY_RATE);
		setDesignation(designation.OTHER);
		System.out.println("employee instance block caleed");
		
		
	}
		
	
	
	//default constructor : A class constructor without any arguements 
	// Constructor is a method  that creates usable objects as simulations
	// public <ClassName> 
	
	//polymorphism
	//Method/constructor overloading: we define same method/constructor 
	//with different number/type of parameter to allow multiple frms of the same method
	
	public Employee() {
		System.out.println("Emlpoyee Deafult Contrucotr Called");
		System.out.println("eno"+getEmpno()+ ",name"+getName()+
							",unit salary:"+getUnitDaySalary()+",designation:"+getDesignation());
						}
	
	
	// this is an internal method called by garbage collector before deleting the object 
	// you can notify to collect the garbage using System.gc();
	public void finalize() {
		setEmpno(0);
		setName(null);
		setUnitDaySalary(0);
		setDesignation(null);
		setGrade(null);
		System.out.println("Emplyoee object finalized");		
	}
	
	
	
	
	public Employee(int empno) {
		this.setEmpno(empno);
		System.out.println("Emlpoyee Deafult Contrucotr Called");
		System.out.println("eno"+getEmpno()+ ",name"+getName()+
				",unit salary:"+getUnitDaySalary()+",designation:"+getDesignation());
		
	}
	
	

	public Employee(int empno, String name, double unitDaySalary, Designations designations) {
		this.setEmpno(empno);
		this.setName(name);
		this.setUnitDaySalary(unitDaySalary);
		this.setDesignation(designations);
		System.out.println("Emlpoyee Deafult Contrucotr Called");
		System.out.println("eno"+getEmpno()+ ",name"+getName()+
				",unit salary:"+getUnitDaySalary()+",designation:"+getDesignation());
		
		
	}
		
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		if (empno>DEFAULT_ZERO && empno < MAX_EMPNO) {
			this.empno = empno;
		}
		
		this.empno = empno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitDaySalary() {
		
		return unitDaySalary;
	}
	
	public void setUnitDaySalary(double unitDaySalary) {
		if(unitDaySalary >MIN_DAY_RATE && unitDaySalary<MAX_DAY_RATE) {
			this.unitDaySalary = unitDaySalary;
		}
	}
	public Designations getDesignation() {
		return designation;
	}
	public void setDesignation(Designations designation) {
		Employee.designation = designation;
	}
	public void setGrade(Grades grade) {
		this.grade = grade;
	}
	public Grades getGrade() {
		return grade;
	}
	// final keyword on methods/
	// final method cannot be overridden in the derived class 
	public double getNetSalary (int noOfDays) throws Exception {
		if(noOfDays<DEFAULT_ZERO) {
			//raise a new exception on business conditions
			throw new Exception (" invalid number of Days"+ noOfDays); 
			
			// raise and unchecked exception on a bussiness condistion
			//throw new RuntimeException(" Invalid input for days"+ noOfDays);
			
		}
		if (noOfDays<DEFAULT_ZERO || noOfDays>MAX_PAID_DAYS) {
			noOfDays=DEFAULT_ZERO;
		}
		return getUnitDaySalary()*noOfDays;
	
	}


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", unitDaySalary=" + unitDaySalary + ", designation="
				+ designation + ", grade=" + grade + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empno;
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
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}
	
	public static String getJSONString(Employee emp) {
		JsonObjectBuilder jsonBuilder = new JsonObjectBuilder();
		jsonBuilder.add("empno", emp.getEmpno());
		jsonBuilder.add("name", emp.getName());
		jsonBuilder.add("day-salary", emp.getUnitDaySalary());
		jsonBuilder.add("desgination",emp.getDesignation().toString());
		jsonBuilder.add("grade",emp.getGrade().toString());
		
		String jsonEmp= jsonBuilder.build().toString();
		System.out.println(jsonEmp);
		return jsonEmp;
		
	}
	
	public static Employee parseJSONString (String empJSON) {
		JsonReader reader = new JsonReader(new StringReader(empJSON));
		JsonObject empJSONobject = reader.readObject();
		
		Employee emp = new Employee();
		emp.setEmpno(empJSONobject.getIntValue("empno"));
		emp.setName(empJSONobject.getStringValue("name"));
		emp.setUnitDaySalary(empJSONobject.getIntValue("day-salary"));
		emp.setGrade(Grades.valueOf(empJSONobject.getStringValue("grade")));
		emp.setDesignation(Designations.valueOf(empJSONobject.getStringValue("designation")));
		
		System.out.println("from Json:"+empJSON);
		System.out.println("To Emp"+emp);
		
		
		reader.close();
		return emp;
	}
	
	public static Document getEmployeeFromMongoDocument(Employee emp) {
		Document docEmp = new Document();
		docEmp.put("empno", emp.getEmpno());
		docEmp.put("name", emp.getName());
		docEmp.put("unit_salary", emp.getUnitDaySalary());
		docEmp.put("grade", emp.getGrade().toString());
		docEmp.put("designation", emp.getDesignation().toString());
		return docEmp; 
	}
	
	public static Employee getEmployeeFromMongoDocument(Document empDoc) {
		Employee emp = new Employee();
		
		
		try {
			emp.setEmpno(empDoc.getInteger("empno"));
			emp.setName(empDoc.getString("name"));
			emp.setUnitDaySalary(empDoc.getDouble("unit_salary"));
			emp.setGrade(Grades.valueOf(empDoc.getString("grade")));
			emp.setDesignation(Designations.valueOf(empDoc.getString("designation")));
		} catch (Exception e) {
			e.printStackTrace();
			emp = null;
		}
		return emp;
		
	}


	public double getNetSalary1(int noOfDays) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
