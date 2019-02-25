package com.example.gateway.rest;


import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import java.net.URL;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import com.example.gateway.model.FreelancersData;
import com.example.gateway.service.FreelancerService;


@Path("/gateway/freelancers")
@RequestScoped
public class GatewayEndPoint {
	
	@Inject
	@ConfigProperty(name = "FREELANCERSERVICE_URL")
	String freelancersvc_url;
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FreelancersData> getFreeLancers() {
		URL apiUrl = null;
		try { 
			//apiUrl = new URL("http://localhost:8090/");
			apiUrl = new URL (freelancersvc_url);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		FreelancerService service = RestClientBuilder.newBuilder().baseUrl(apiUrl).build(FreelancerService.class);
		return service.getFreelancers();
		
	}
	
	@GET
	@Path("/{guid}")
	@Produces(MediaType.APPLICATION_JSON)
	public FreelancersData getFreeLancersByGuid(@PathParam("guid") String guid) {
		URL apiUrl = null;
		try { 
			apiUrl = new URL (freelancersvc_url);
			//apiUrl = new URL("http://localhost:8090/");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		FreelancerService service = RestClientBuilder.newBuilder().baseUrl(apiUrl).build(FreelancerService.class);
		return service.getFreelancersByGuid(guid);
		
	}
}
