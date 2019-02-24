package com.example.freelancer;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.freelancer.model.FreelancerData;
import com.example.freelancer.service.FreelancerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FreelancerApplicationTests {

	@Autowired
	private FreelancerService service;
	
	@Test
	public void getAll() {
		List <FreelancerData> data = service.findAll();
		assertEquals(2, data.size());
	}

	
	@Test
	public void getGuid() {
		FreelancerData fd = service.findByGuid("1");
		assertEquals("test@abc.com", fd.getEmailId());
	}
}
