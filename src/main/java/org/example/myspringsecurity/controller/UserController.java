package org.example.myspringsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/info/{id}")
    public String userInfo(@PathVariable("id") Long id, Model model) {
        userService.findById(id)
                .ifPresent(person -> model.addAttribute("person", person));

        return "user/info";
    }
}