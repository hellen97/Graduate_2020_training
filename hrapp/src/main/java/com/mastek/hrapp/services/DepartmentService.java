package com.mastek.hrapp.services;

 
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.mastek.hrapp.apis.DepartmentAPI;
import com.mastek.hrapp.dao.DepartmentJPADAO;
import com.mastek.hrapp.entities.Department;

public class DepartmentService implements DepartmentAPI {
String exampleProperty;

@Autowired
DepartmentJPADAO deptDAO;
    
    public DepartmentService() {
        System.out.println("Department Service Created");
    }
    
    @PostConstruct // Initialisation method of the class 
    public void initalizeService() {
        System.out.println("Department Service Initialized");
    }
    
    @PreDestroy // calls before the shutting down of the application
    public void terminateService() {
        System.out.println("Department Service Terminated");
    }
    
    public void exampleMethod() {
        System.out.println("Connect to "+ getExampleProperty()+ " for business data");
    }
    
    public String getExampleProperty() {
        return exampleProperty;
    }
    @Value("Spring Example Data Source")    // if you don't set the value the property will not be set 
    public void setExampleProperty(String exampleProperty) {
        System.out.println("Example Property Set :"+exampleProperty);
        this.exampleProperty = exampleProperty;
    }
    @Override 
	public Iterable<Department>listAllDepartments(){
	System.out.print("listing all Departments");
	return deptDAO.findAll();
}

@Override
public Department findByDeptno(int depno) {
	// TODO Auto-generated method stub
	return deptDAO.findById(depno).get();
}
@Override
public Department registerNewDepartment (Department newDepartment) {
	// TODO Auto-generated method stub
	newDepartment = deptDAO.save(newDepartment);
	return newDepartment;
}
}