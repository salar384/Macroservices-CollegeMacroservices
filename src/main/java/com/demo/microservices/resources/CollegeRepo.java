package com.demo.microservices.resources;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.microservices.entity.College;

public interface CollegeRepo extends JpaRepository<College, Integer> {

}
