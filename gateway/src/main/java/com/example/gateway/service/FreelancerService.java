package com.example.gateway.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.example.gateway.model.FreelancersData;

@Path("/freelancers")
@Consumes("application/json")
public interface FreelancerService {

	@GET
	List<FreelancersData> getFreelancers();
	
	@GET
	@Path("/{guid}")
	FreelancersData getFreelancersByGuid(@PathParam("guid") String guid);
}
