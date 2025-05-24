package com.example.webbulletin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webbulletin.models.Post;
import com.example.webbulletin.repositories.PostRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findByPostNumber(Integer postNumber) {
		return postRepository.findByPostNumber(postNumber);
	}
	
	
	public List<Post> findByStatusDelete(String statusDelete){
		return postRepository.findByStatusDelete(statusDelete);
	}
		
	
	public List<Post> findAll(){
		return findAll();
	}
	
	public void deleteByPostNumber(Integer postNumber) {
		deleteByPostNumber(postNumber);
	}


	public Post getById(int postNumber) {
		return postRepository.getById(postNumber);
	}


	public @Valid Post save(@Valid Post pst) {
		return postRepository.save(pst);
	}


	public List<Post> saveAll(List<Post> posts) {
		
		return postRepository.saveAll(posts);
		
	}
	
	public List<Post> findByPostTitleContains(String keyWord){
		
		return postRepository.findByPostTitleContains(keyWord);
		
	}

	
}
