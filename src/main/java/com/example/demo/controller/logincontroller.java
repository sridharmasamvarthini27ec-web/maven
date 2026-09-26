package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.User;
import com.example.demo.repo.UserRepository;

@Controller
public class logincontroller {

    @Autowired
    private UserRepository repo;

    @GetMapping("/signin")
    public String showLoginPage() {
        return "login.html";
    }

    @PostMapping("/signin")
    public String loginUser(
            @RequestParam String studentname,
            @RequestParam String password) {

        User user = repo.findByStudentnameAndPassword(studentname, password);

        if (user == null) {
            return "redirect:/login.html";
        }

        return "redirect:/home.html";
    }
}