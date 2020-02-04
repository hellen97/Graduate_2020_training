package com.mastek.training.hrapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mysql.jdbc.Driver;

public class EmployeeJDBCDAO implements DataAccessObject<Employee> {
	
	Connection conMysql;
	
	public EmployeeJDBCDAO() {
		//1. Load the databse server
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//2 open connection to MySQL
			conMysql = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/graduate_2020_masteknet", //DataBase 
					"root", // userName 
					"root"); // password
			System.out.println("connnection succesful"); 
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	@Override
	public Employee add(Employee newEmployee) {
		
		//1. define the query in SQL formmat with parameters if reuqired 
		String sqlInsert = "insert into jdbc_employees "
							+" (empno,name,unit_salary,grade,designation) "
							+" values(?,?,?,?,?)";
		//2, prepare the statement object for the query 
		try (PreparedStatement psInsert = conMysql.prepareStatement(sqlInsert)){
			//data type, set / parameters to assing to. 
			
			psInsert.setInt(1,newEmployee.getEmpno());
			psInsert.setString(2,newEmployee.getName());
			psInsert.setDouble(3,newEmployee.getUnitDaySalary());
			psInsert.setString(4,newEmployee.getGrade().toString());
			psInsert.setString(5,newEmployee.getDesignation().toString());
			// 4. execute the query on the database table return the rows affected
			
			int recordsAffected = psInsert.executeUpdate(); // INSERT/UPDATE/DELETE SQLS 
			System.out.println(recordsAffected+ "employee inserted");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			newEmployee = null ; // return null in case of failure
							}
	return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		String sqlSelectALL = "select * from jdbc_employees";
		List<Employee> employees = new LinkedList<Employee>();
		
		try (Statement stSelectAll = conMysql.createStatement()){
			ResultSet rsEmployess = stSelectAll.executeQuery(sqlSelectALL);
			while(rsEmployess.next()) { // loop untill result set has next record 
				//create object for each record in databsae 
				Employee e = new Employee();
				e.setEmpno(rsEmployess.getInt("empno"));
				e.setName(rsEmployess.getString("name"));
				e.setUnitDaySalary(rsEmployess.getDouble("Unit_salary"));
				e.setGrade(Grades.valueOf(rsEmployess.getString("grade")));
				e.setDesignation(Designations.valueOf(rsEmployess.getString("designations")));
				
				// add the data to collection 
				employees.add(e); 
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return employees; // returns the collection with employess fetche from DB
	}

	@Override
	public Employee find(int key) {
	String findSQL = "Select * from jdbc_employees where empno=?";
	Employee emp = null; 
	try( PreparedStatement psFind = conMysql.prepareStatement(findSQL)) {
		
		
		psFind.setInt(1, key); // set the empno for search 
		
		ResultSet rsFindResult = psFind.executeQuery();
		
		if (rsFindResult.next()){
			emp = new Employee();
			emp.setEmpno(rsFindResult.getInt("empno"));
			emp.setName(rsFindResult.getString("name"));
			emp.setUnitDaySalary(rsFindResult.getDouble("unit_salary"));
			emp.setGrade(Grades.valueOf(rsFindResult.getString("gragde")));
			emp.setDesignation(Designations.valueOf(rsFindResult.getString("designation")));
		}
		
	} catch (Exception e)
	{
		e.printStackTrace();
	}

	return emp;
	}

	@Override
	public Employee remove(int key) {
		Employee empToBeRemoved = find(key);
			if(empToBeRemoved!=null) {
				String sqlDelete = "delete from jdbc_employees where empno=?";
				 try (PreparedStatement psDelete = conMysql.prepareStatement(sqlDelete)){
					
					 psDelete.setInt(1,key);
					 
					 int rowsDeleted = psDelete.executeUpdate();
					 System.out.println (rowsDeleted +"Employee deleted due to harrasment");
					
				} catch (Exception e) {
				e.printStackTrace();
				}
				
		
			}
			return empToBeRemoved;
		}
		
	}



