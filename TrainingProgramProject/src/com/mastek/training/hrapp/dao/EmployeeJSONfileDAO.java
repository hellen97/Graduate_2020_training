package com.mastek.training.hrapp.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.mastek.training.hrapp.Employee;

	public class EmployeeJSONfileDAO implements DataAccessObject<Employee> {
	Map<Integer, Employee> empMap;
	String fileName;

	public EmployeeJSONfileDAO(String fileName) {
													empMap = new HashMap<>();
													this.fileName=fileName;
												}

	@Override
	public Employee add(Employee newEmployee) {
		if(!empMap.containsKey(newEmployee.getEmpno())) {
			
		empMap.put(newEmployee.getEmpno(), newEmployee);
		
	}
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readJSONfileData();
		
		return empMap.values();
	}

	@Override
	public Employee find(int key) {
		readJSONfileData();
	
	return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		Employee removedEmp = null;
		if(empMap.containsKey(key)){
			removedEmp= empMap.remove(key);
		}
		return removedEmp;
	}
	
	private void readJSONfileData() {
		//bufferedReader: it reads line by line data from Sting/text/json file 
		// it reads the text data from file (fileReader) 
		// File: it helps to refer / create file in the system
		
		try (BufferedReader brJSONfile = new BufferedReader
							(new FileReader(FileReader (fileName)))) {
			String line =brJSONfile.readLine();
			while(line!=null) {
				Employee emp = Employee.parseJSONString((line));
				empMap.put(emp.getEmpno(), emp);
				line = brJSONfile.readLine();
			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
	
private String FileReader(String fileName2) {
		// TODO Auto-generated method stub
		return null;
	}

private void writeJSONFileData() {
    //BufferedWrites: Writes line by line data from string/text/json file
    //FileReader: it reads text data from a file
    //File: it helps to refer/create a file in the system

try(BufferedWriter bw = new BufferedWriter(
                            new FileWriter(
                                 new File(fileName)))) {
    for(Integer empno:empMap.keySet()) {
        bw.write(Employee.getJSONString(
                          empMap.get(empno))+"\n");
    }
   
} catch (Exception e) {
    e.printStackTrace();
}
		
		
	}
	

}
