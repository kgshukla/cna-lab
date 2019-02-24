package com.example.freelancer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.freelancer.model.FreelancerData;
import com.example.freelancer.repository.FreelancerRepository;

@Service
public class FreelancerService {
	
	@Autowired
	FreelancerRepository repo;
	
	public List<FreelancerData> findAll() {
		return (List<FreelancerData>)repo.findAll(); 
	};
	
	public FreelancerData findByGuid(String guid) {
		return repo.findByGuid(guid);
	}
}
