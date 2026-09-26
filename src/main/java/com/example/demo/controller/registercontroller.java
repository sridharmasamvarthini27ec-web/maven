package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.User;
import com.example.demo.repo.UserRepository;

@Controller
public class registercontroller {

    @Autowired
    private UserRepository repo;

    @GetMapping("/signup")
    public String showSignupPage() {
        return "register.html";
    }

    @PostMapping("/signup")
    public String registerUser(
            @RequestParam String studentname,
            @RequestParam String password) {

        User user = new User(studentname, password);

        repo.save(user);

        return "redirect:/login.html";
    }
}