package com.mastek.training.hrapp.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

public class EmployeeBinaryFileDAO implements DataAccessObject<Employee> {
	
	Map<Integer, Employee> empMap;
	private String fileName;

	public EmployeeBinaryFileDAO(String fileName) {
													empMap = new HashMap<Integer, Employee>();
													this.fileName = fileName;
													// read all the data from file and load in the collection map 
													readMapFromFile(); 
		
													}
	private void readMapFromFile() {
		//ObjectInputStream: Read object from Binart FileInputStream
		//FileStreamInput: Read Binary data from file objects 
		//File:mopen or refer to he file using Filename or filepath
		try(ObjectInputStream objIn = new ObjectInputStream (
																new FileInputStream(
																		new File(fileName)))) { 
			
			// we use try blick with resoruces to namahge autoclosing of streams 
			empMap = (Map<Integer, Employee>) objIn.readObject();
			
		} catch (Exception e) {
			System.out.println("Exception thrown");
			e.printStackTrace();
		}
	}
	// read the data from file and add it to the map shared 
	private void writeMapToFile() {
		
		//ObjextOutputStream: Write ninary onject in serialised format in FileOutputStream
		//FileOutputStream: Write binary objects to files.
		//File: File object will refer to the gile to be updated/ created if not present.
		try(ObjectOutputStream objOut = new ObjectOutputStream(
																new FileOutputStream(
																						new File (fileName)))){
		
			objOut.writeObject(empMap);// write all the data in serialized format in file 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//update file with the Map content 
	@Override
	public Employee add(Employee newEmployee) {
		readMapFromFile(); 
		if(!empMap.containsKey(newEmployee.getEmpno())){
			
		empMap.put((newEmployee.getEmpno()), newEmployee);
		//update the file with new content
		writeMapToFile();
		}
		
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readMapFromFile(); 
		return empMap.values(); //return all the values from the map 
	}

	@Override
	public Employee find(int key) {
		readMapFromFile(); 
		return empMap.get(key);
		
	}

	@Override
	public Employee remove(int key) {
	readMapFromFile(); 
	
	Employee removedEmp=null ;
	if (empMap.containsKey(key)) {
		removedEmp = empMap.remove(key);
		writeMapToFile();
	}	
	return removedEmp;
	}

}
