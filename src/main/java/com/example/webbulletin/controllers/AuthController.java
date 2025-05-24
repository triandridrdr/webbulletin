package com.example.webbulletin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webbulletin.dto.UserData;
import com.example.webbulletin.models.Post;
import com.example.webbulletin.models.User;
import com.example.webbulletin.repositories.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResul) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Enkripsi password
        user.setRole("USER");
        
        //Coba mapping
    	//System.out.println("Sebelum mapping untuk register");
    	//User user = modelMapper.map(userData, User.class);
    	
    	String result = "";
		
		if (bindingResul.hasErrors()) {
			System.out.println("Error validasi");
			result = "/register";
		} else {
			System.out.println("tidak masuk Error validasi");
			userRepository.save(user);
			result = "redirect:/login";
		}
    	
        return result;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
    
    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        request.logout(); // Memanggil logout dari servlet
        return "redirect:/login?logout";
    }
}
