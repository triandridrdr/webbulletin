package com.example.webbulletin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webbulletin.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

	List<Post> findByPostNumber(Integer postNumber);

	List<Post> findByStatusDelete(String statusDelete);
	
	 Post getById(int postNumber);
	 
	 List<Post> findByPostTitleContains(String keyWord);
	
}
