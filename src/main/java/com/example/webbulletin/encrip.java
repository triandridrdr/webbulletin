package com.example.webbulletin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encrip {

	public static void main(String[] args) {
	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "123456";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Password terenkripsi: " + encodedPassword);
	}
}
