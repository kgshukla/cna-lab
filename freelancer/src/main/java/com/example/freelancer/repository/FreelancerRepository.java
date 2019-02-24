package com.example.freelancer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.freelancer.model.FreelancerData;

@Repository
public interface FreelancerRepository extends CrudRepository<FreelancerData, Long> {
	 
    FreelancerData findByGuid(@Param("guid") String guid);
}
