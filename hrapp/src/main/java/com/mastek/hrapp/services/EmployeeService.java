package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.apis.EmployeeAPI;
import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPostionsDAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPostion;
import com.mastek.hrapp.entities.Project;

@Component //marking the class as bean to be created
@Scope("singleton") // singleton:One object used across test cases, prototype: one object per request
	public class EmployeeService implements EmployeeAPI {

	String exampleProperty;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmentJPADAO deptDAO;
	
	@Autowired
	ProjectJPADAO projectDAO; 
	
	@Autowired
	JobPostionsDAO jobsDAO;
	
	
	
	
	public EmployeeService() {
		System.out.println("Employee Service Created");
	}

	@PostConstruct // initialization method of the class
	public void initalizeService() {
		System.out.println("Employee Service Initialized");
	}

	@PreDestroy // calls before the shutting down the application
	public void terminateService() {
		System.out.println("Employee Service Terminated");
	}
	
	
	public void exampleMethod() {
		System.out.println("Connect to "+getExampleProperty()+" for business data");
	}
	
	public String getExampleProperty() {
		return exampleProperty;
	}

	@Value("Spring Example Data Source") // initialize the property with the simple value
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example Property Set :"+exampleProperty);
		this.exampleProperty = exampleProperty;
	}
	
	
	@Transactional 
	public Employee assignEmployeeToDepartment(int empno, int deptno) {
	
		Employee emp = empDAO.findById(empno).get();
		Department dept = deptDAO.findById(deptno).get();
		
		//assign the assoication between and department
		emp.setCurrentDepartment(dept);  // assign the department to employee
		dept.getTeam().add(emp);	    // add the employee in the department team 
		
		
		// save the changes in database 
		empDAO.save(emp);
		deptDAO.save(dept);
		
		return emp; // return the result 
	}
@Transactional //
	public Employee assignEmployeeToProject(int empno , int projectId) {
	Employee emp = empDAO.findById(empno).get();// get employee object 
	Project newProject = projectDAO.findById(projectId).get(); //get the project object 
	
	emp.getProjectsAssigned().add(newProject); //assign employee to project
	empDAO.save(emp);

	return emp; //return employee object 
	}
	
@Transactional
	public JobPostion applyForJobPosition (int jobId, int empno) {
	System.out.println("Applying for Job");
	JobPostion job = jobsDAO.findById(jobId).get();
	System.out.println(job);
	
	Employee emp = empDAO.findById(empno).get();
	System.out.println(emp);
	
	job.getApplicants().add(emp);
	job= jobsDAO.save(job);
	return job;
	
	}

@Override 
	public Iterable<Employee>listAllEmployees(){
	System.out.print("listing all employees");
	return empDAO.findAll();
}

@Override
public Employee findByEmpno(int empno) {
	// TODO Auto-generated method stub
	return empDAO.findById(empno).get();
}
@Override
public Employee registerNewEmployee(Employee newEmployee) {
	// TODO Auto-generated method stub
	newEmployee = empDAO.save(newEmployee);
	return newEmployee;
}
}
