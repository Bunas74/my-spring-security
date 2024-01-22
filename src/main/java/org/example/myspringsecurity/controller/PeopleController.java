package org.example.myspringsecurity.controller;

import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.example.myspringsecurity.service.impl.PeopleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleServiceImpl peopleService;

    @GetMapping("/people")
    public String findAll(Model model, Principal principal) {
        peopleService.findByUsername(principal.getName())
                .ifPresent(person -> model.addAttribute("role", person.getRole()));
        model.addAttribute("people", peopleService.findAll());

        return "people";
    }
}