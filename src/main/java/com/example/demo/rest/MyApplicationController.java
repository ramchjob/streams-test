package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.ApplicationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@Slf4j
public class MyApplicationController {
	
	
	private ApplicationService service;
	
	@GetMapping("/user/{id}")
	public Mono<User> getUsers(@PathVariable("id") Integer id) {
		log.debug("Received request to get user by id {} ", id);
		return service.getUser(id);
	}
	
	@GetMapping("/users")
	public Flux<User> getUsers() {
		log.debug("Received request to get users");
		return service.getUsers();
	}

}
