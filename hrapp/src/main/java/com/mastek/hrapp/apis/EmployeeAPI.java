package com.mastek.hrapp.apis;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Employee;

@Path("/hrapp/") // map the URL pattern with the class as service
public interface EmployeeAPI {
	
	//http :// localhost:7777/hrapp/employees/list
	@GET
	@Path("/employees/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Employee> listAllEmployees();

}
