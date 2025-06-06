package com.example.webbulletin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webbulletin.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

