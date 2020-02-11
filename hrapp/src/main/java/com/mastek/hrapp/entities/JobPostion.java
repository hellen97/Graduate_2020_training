package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document (collection ="JPA_INTERNAL_JOB_POSTIONS")
public class JobPostion {
	 
	 int jobId;
	 String clientName; 
	 int noOfPostions;
	 String skillesRequierd; 
	 String location;
	 
	 Set<Employee> applicants = new HashSet<>();
	 
	
	 public Set<Employee> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<Employee> applicants) {
		this.applicants = applicants;
	}

	public JobPostion() {
			
		}
	@Id
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getNoOfPostions() {
		return noOfPostions;
	}
	public void setNoOfPostions(int noOfPositions) {
		this.noOfPostions = noOfPositions;
	}
	public String getSkillesRequierd() {
		return skillesRequierd;
	}
	public void setSkillesRequierd(String skillesRequierd) {
		this.skillesRequierd = skillesRequierd;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	 

}
