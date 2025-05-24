package com.example.webbulletin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webbulletin.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}