package com.mastek.hrapp.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mastek.hrapp.entities.Department;

@Path("/hrapp/") // map the URL pattern with the class as service
public interface DepartmentAPI {
	
	//http :// localhost:7777/hrapp/department/list
	@GET
	@Path("/department/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Department> listAllDepartments();
	
	
	@GET //http method to get the data thats being reuwsted 
	@Path("/department/find/{empno}")
	@Produces({MediaType.APPLICATION_JSON})
	public Department findByDeptno(@PathParam("depno")int deptno);
	
	@POST // http mthod post used to send data in requests
	@Path("/department/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Department registerNewDepartment (@BeanParam Department newDepartment);

}
