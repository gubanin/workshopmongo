package com.example.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User u1 = new User(null, "Gustavo", "gu@gmail.com");
		User u2 = new User(null, "Lucas", "lu@gmail.com");
		User u3 = new User(null, "Vanderlei", "vanu@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
	}

}
