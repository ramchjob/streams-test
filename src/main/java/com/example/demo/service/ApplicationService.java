package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class ApplicationService {
	
	@Autowired
	WebClient webClient;
	
	public Mono<User> getUser(int id) {
		log.debug("Received request to get user by id {} ", id);
		return webClient
        .get()
        .uri(String.join("", "/users/", String.valueOf(id)))
        .retrieve()
        .bodyToMono(User.class);
	}
	
	public Flux<User> getUsers() {
		log.debug("Received request to get users");
		return webClient
        .get()
        .uri(String.join("", "/users/"))
        .retrieve()
        .bodyToFlux(User.class);
	}

}
