package com.example.livetest.controller;

import com.example.livetest.model.User;
import com.example.livetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String saveUser(@ModelAttribute User user) {

        System.out.println(">>> FORM SUBMITTED");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Message: " + user.getMessage());

        userRepository.save(user);

        return "Data submitted successfully!";
    }
}
