package com.example.webbulletin.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer postNumber;
    private String postTitle;
    //@NotEmpty(message = "Name is Required")
    //private String authorName;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id") // foreign key di table post
    private Author author;
    
    private Integer viewers;
    private Date created;
    private Date modifyDate;
    private String password;
    private String body;
    private String statusDelete;

    // for JPA only, no use
    public Post() {
    }

    public Post(String postTitle, Integer viewers, Date created, Date modifyDate, String password, String body, String statusDelete) {
        this.postTitle = postTitle;
        this.viewers = viewers;
        this.created = created;
        this.modifyDate = modifyDate;
        this.password = password;
        this.body = body;
        this.statusDelete = statusDelete;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postNumber=" + postNumber +
                ", postTitle='" + postTitle + '\'' +
                ", viewers=" + viewers +
                ", created=" + created +
                ", modifyDate=" + modifyDate +
                ", password=" + password +
                ", body=" + body +
                ", statusDelete=" + statusDelete +
                '}';
    }

	public Integer getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(Integer postNumber) {
		this.postNumber = postNumber;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public Integer getViewers() {
		return viewers;
	}

	public void setViewers(Integer viewers) {
		this.viewers = viewers;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatusDelete() {
		return statusDelete;
	}

	public void setStatusDelete(String statusDelete) {
		this.statusDelete = statusDelete;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	
   
}
