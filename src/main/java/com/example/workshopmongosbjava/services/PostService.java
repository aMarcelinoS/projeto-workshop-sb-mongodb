package com.example.workshopmongosbjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongosbjava.domain.Post;
import com.example.workshopmongosbjava.repository.PostRepository;
import com.example.workshopmongosbjava.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}	
}
