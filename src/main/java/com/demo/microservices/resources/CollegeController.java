package com.demo.microservices.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.microservices.entity.Address;
import com.demo.microservices.entity.College;

@RestController
@RequestMapping("/college")
public class CollegeController {
	
	@Autowired
	CollegeRepo repo;

	@Autowired
	RestTemplate restTemplate;
	
	
	
	@GetMapping("/{cid}")
	public College getCollege(@PathVariable("cid") int cid) {
		
		College c= repo.findById(cid).get();
		Address a = restTemplate.getForObject("http://addressmicroservices/address/"+c.getAid(), Address.class);
		c.setAddress(a);
		return c;
		
	}
	
	
	
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		RestTemplate template = new RestTemplate();
		return template;
	}

}
