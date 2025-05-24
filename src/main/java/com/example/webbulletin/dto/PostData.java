package com.example.webbulletin.dto;

import java.util.Date;

import com.example.webbulletin.models.Author;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PostData {
	
	private Integer postNumber;
    private String postTitle;
    private Author author;
    private Integer viewers;
    private Date created;
    private Date modifyDate;
    private String password;
    private String body;
    private String statusDelete;
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
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
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
	public PostData(Integer postNumber, String postTitle, Author author, Integer viewers, Date created, Date modifyDate,
			String password, String body, String statusDelete) {
		this.postNumber = postNumber;
		this.postTitle = postTitle;
		this.author = author;
		this.viewers = viewers;
		this.created = created;
		this.modifyDate = modifyDate;
		this.password = password;
		this.body = body;
		this.statusDelete = statusDelete;
	}
	public PostData() {
	}
	
	
    
    
    

}
