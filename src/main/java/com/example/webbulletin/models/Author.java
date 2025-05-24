package com.example.webbulletin.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="authors")
public class Author {
	
		@Id
	    //@GeneratedValue(strategy = GenerationType.AUTO)
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
	    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Integer id;
		
		private String name;
		
		@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	    private List<Post> posts;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		

		public List<Post> getPosts() {
			return posts;
		}

		public void setPosts(List<Post> posts) {
			this.posts = posts;
		}

		public Author() {
			
		}

		public Author(Integer id, String name, List<Post> posts) {
			this.id = id;
			this.name = name;
			this.posts = posts;
		}

		
		
		
		

}
