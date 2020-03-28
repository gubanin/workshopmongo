package com.example.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.AuthorDTO;
import com.example.workshopmongo.repositories.PostRepository;
import com.example.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
		
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		postRepository.deleteAll();
		userRepository.deleteAll();
		
		User gu = new User(null, "Gustavo", "gu@gmail.com");
		User lu = new User(null, "Lucas", "lu@gmail.com");
		User van = new User(null, "Vanderlei", "vanu@gmail.com");
		
		userRepository.saveAll(Arrays.asList(gu,lu,van));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Virei programador", "To procurando vaga de junior!",new AuthorDTO(gu));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Arrumei um trampo", "java junior!",new AuthorDTO(gu));

		postRepository.saveAll(Arrays.asList(p1,p2));
		
		gu.getPosts().addAll(Arrays.asList(p1,p2));
		userRepository.save(gu);
	}

}
