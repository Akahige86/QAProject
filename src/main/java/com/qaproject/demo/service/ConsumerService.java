package com.qaproject.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qaproject.demo.clients.Consumer;
import com.qaproject.demo.exceptions.NoClientFound;
import com.qaproject.demo.repositories.ConsumerRepo;

@Service
public class ConsumerService {
	
	private ConsumerRepo cr;
	
	@Autowired
	public ConsumerService(ConsumerRepo cr) {
		this.cr = cr;
	}

	public Consumer login(String email, String password) {
		Optional<Consumer> login = Optional.ofNullable(this.cr.findConsumerByEmailAndPassword(email, password));
		return login.orElseThrow(() -> new NoClientFound("No such Client"));
	}
	
	public Consumer register(Consumer body) {
		return Optional.ofNullable(this.cr.save(body)).orElseThrow(() -> new NoClientFound("No such Client"));
	}
	
	public Boolean delete(Integer id) {
		Integer idO = Optional.of(id).orElseThrow(() -> new NoClientFound("Null for ID"));
		if(cr.existsById(idO)) {
			cr.deleteById(idO);
			return true;
		} else return false;
		
	}

}