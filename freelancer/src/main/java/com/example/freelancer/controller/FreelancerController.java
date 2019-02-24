package com.example.freelancer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.freelancer.model.FreelancerData;
import com.example.freelancer.service.FreelancerService;

@RestController
public class FreelancerController {

	@Autowired
	FreelancerService service;
	
	@RequestMapping(value = "/freelancers", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<FreelancerData> getAll(){
        return service.findAll();
	}
	
	@RequestMapping(value = "/freelancers/{guid}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public FreelancerData getById(@PathVariable("guid") String guid){
		return service.findByGuid(guid);
	}
}
