package com.mastek.hrapp.apis;



import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import com.mastek.hrapp.services.DepartmentService;
import com.mastek.hrapp.services.EmployeeService;
import com.mastek.training.hrapp.apis.ProjectService;



// create the Jersey Server configuration class

@Component

public class APIconfig extends ResourceConfig{



	public APIconfig() {

		//register each Service class in ResourceConfig

		register(EmployeeService.class);

	//	register(DepartmentService.class);

	// register(ProjectService.class);

	}

}