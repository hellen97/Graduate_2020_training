package com.mastek.hrapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.JobPostion;

@Repository
public interface JobPostionsDAO extends
	MongoRepository<JobPostion, Integer> {

}
