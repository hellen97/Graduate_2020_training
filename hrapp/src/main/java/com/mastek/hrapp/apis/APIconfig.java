package com.mastek.hrapp.apis;



import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import com.mastek.hrapp.services.DepartmentService;
import com.mastek.hrapp.services.EmployeeService;



// create the Jersey Server configuration class

@Component

public class APIconfig extends ResourceConfig{



	public APIconfig() {
		//enable the CORS filter for UI applications to access the service 
		register(CORSFilter.class);
		
		//register each Service class in ResourceConfig

		register(EmployeeService.class);

	//	register(DepartmentService.class);

	// register(ProjectService.class);

	}

}